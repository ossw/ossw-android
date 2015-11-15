package com.althink.android.ossw.watchsets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;
import com.althink.android.ossw.UploadDataType;
import com.althink.android.ossw.db.OsswDatabaseHelper;
import com.althink.android.ossw.db.WatchSetInfo;
import com.althink.android.ossw.service.OsswService;

import java.util.ArrayList;

/**
 * Created by krzysiek on 13/06/15.
 */
public abstract class WatchSetsFragment extends ListFragment {

    private final static String TAG = WatchSetsFragment.class.getSimpleName();
    private LayoutInflater mInflater;
    private static final int FILE_SELECT_CODE = 0;
    private Toolbar bottomToolbar;
    private WatchSetsListAdapter listAdaptor;
    private WatchSetType type;
    private Handler toastHandler = new Handler();

    public WatchSetsFragment(WatchSetType type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflater = inflater;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watchsets, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        listAdaptor = new WatchSetsListAdapter();
        setListAdapter(listAdaptor);

        //Log.i(TAG, "On create");
    }

    private void refreshWatchSetList() {
        listAdaptor.clear();
        for (WatchSetInfo info : OsswDatabaseHelper.getInstance(getActivity()).listWatchSets(type)) {
            listAdaptor.addWatchSet(info);
        }
        listAdaptor.notifyDataSetChanged();
        resetSelection();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int count = getListView().getCount();
//        SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
//        for (int i = 0; i < count; i++) {
//            if (sparseBooleanArray.get(i)) {
//                prompt += getListView().getItemAtPosition(i).toString() + "\n";
//            }
//        }
        int checkedCount = getListView().getCheckedItemCount();

        setMenuOptions(checkedCount > 0 ? (checkedCount > 1 ? Mode.MULTI : Mode.SINGLE) : Mode.NONE);
    }

    private void setMenuOptions(Mode mode) {
        View uploadAction = bottomToolbar.findViewById(R.id.menu_upload_to_watch);
        View itemsRemoveAction = bottomToolbar.findViewById(R.id.menu_items_remove);
        switch (mode) {
            case MULTI:
                enableDeselectOption();
                uploadAction.setVisibility(View.GONE);
                itemsRemoveAction.setVisibility(View.VISIBLE);
                break;
            case SINGLE:
                enableDeselectOption();
                uploadAction.setVisibility(View.VISIBLE);
                itemsRemoveAction.setVisibility(View.VISIBLE);
                break;
            case NONE:
                disableDeselectOption();
                uploadAction.setVisibility(View.GONE);
                itemsRemoveAction.setVisibility(View.GONE);
                break;
        }
    }

    private void disableDeselectOption() {
        bottomToolbar.setNavigationIcon(null);
        bottomToolbar.setNavigationOnClickListener(null);
    }

    private void enableDeselectOption() {
        bottomToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        bottomToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSelection();
            }
        });
    }

    private void resetSelection() {
        getListView().clearChoices();
        getListView().requestLayout();
        setMenuOptions(Mode.NONE);
    }

    @Override
    public void onResume() {
        super.onResume();

        MainActivity activity = ((MainActivity) getActivity());
        activity.resetBottomToolbar();
        bottomToolbar = activity.getBottomToolbar();

        bottomToolbar.inflateMenu(R.menu.watchsets);
        bottomToolbar.setVisibility(View.VISIBLE);

        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                OsswDatabaseHelper db = OsswDatabaseHelper.getInstance(getActivity());

                if (id == R.id.menu_import) {
                    showFileChooser();
                    return true;
                } else if (id == R.id.menu_items_remove) {

                    SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
                    int count = getListView().getCount();
                    for (int i = 0; i < count; i++) {
                        if (sparseBooleanArray.get(i)) {
                            WatchSetInfo info = (WatchSetInfo) getListAdapter().getItem(i);
                            db.deleteWatchSet(info.getId());
                        }
                    }
                    refreshWatchSetList();
                    return true;
                } else if (id == R.id.menu_upload_to_watch) {
                    SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
                    int count = getListView().getCount();
                    for (int i = 0; i < count; i++) {
                        if (sparseBooleanArray.get(i)) {
                            try {
                                WatchSetInfo info = (WatchSetInfo) getListAdapter().getItem(i);
                                String source = db.getWatchSetSourceById(info.getId());
                                Integer extWatchSetId = db.getExtWatchSetId(info.getId());
                                CompiledWatchSet compiledWatchSet = new WatchSetCompiler(getActivity()).compile(source, extWatchSetId);
                                OsswService osswBleService = OsswService.getInstance();
                                if (osswBleService != null) {
                                    osswBleService.uploadData(buildDataType(type), compiledWatchSet.getName(), compiledWatchSet.getWatchData());
                                }
                            } catch(Exception e) {
                                toastHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), getString(R.string.toast_invalid_file), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            resetSelection();
                            return true;
                        }
                    }
                }
                return false;
            }
        });

        refreshWatchSetList();
        setMenuOptions(Mode.NONE);
    }

    protected UploadDataType buildDataType(WatchSetType type) {
        switch (type) {
            case WATCH_FACE:
                return UploadDataType.WATCH_FACE;
            case APPLICATION:
                return UploadDataType.APPLICATION;
            case UTILITY:
                return UploadDataType.UTILITY;
        }
        return null;
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    0);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(getActivity(), "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Log.i(TAG, "result code: " + resultCode);
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    //Log.i(TAG, "File Uri: " + uri.toString());
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    WatchSetImportFragment importFragment = new WatchSetImportFragment();
                    importFragment.setUri(uri);
                    importFragment.setWatchsetType(type);
                    ft.replace(R.id.fragment_container, importFragment).addToBackStack(null);
                    ft.commit();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Log.i(TAG, "On destroy");
    }

    private class WatchSetsListAdapter extends BaseAdapter {
        private ArrayList<WatchSetInfo> mWatchSets;

        public WatchSetsListAdapter() {
            super();
            mWatchSets = new ArrayList<WatchSetInfo>();
        }

        public void addWatchSet(WatchSetInfo plugin) {
            mWatchSets.add(plugin);
        }

        public WatchSetInfo getWatchSet(int position) {
            return mWatchSets.get(position);
        }

        public void clear() {
            mWatchSets.clear();
        }

        @Override
        public int getCount() {
            return mWatchSets.size();
        }

        @Override
        public Object getItem(int i) {
            return mWatchSets.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            // General ListView optimization code.
            if (view == null) {
                view = mInflater.inflate(R.layout.listitem_watchset, null);
                viewHolder = new ViewHolder();
                viewHolder.watchSetName = (TextView) view.findViewById(R.id.watchset_name);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            WatchSetInfo info = mWatchSets.get(i);
            viewHolder.watchSetName.setText(info.getName());
            return view;
        }
    }

    static class ViewHolder {
        TextView watchSetName;
    }

    private enum Mode {
        NONE, SINGLE, MULTI
    }
}