package com.althink.android.ossw.watchsets;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
    private static final int WATCH_FACE_IMPORTED = 1;
    private LayoutInflater mInflater;
    private static final int FILE_SELECT_CODE = 0;

    private WatchSetsListAdapter listAdapter;
    private WatchSetType type;
    private Handler toastHandler = new Handler();

    public WatchSetsFragment(WatchSetType type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called");
        mInflater = inflater;
        View v = inflater.inflate(R.layout.fragment_watchsets, container, false);
        setHasOptionsMenu(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        }
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate called");
        listAdapter = new WatchSetsListAdapter();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated called");
        setTitle(buildTitle());
        setListAdapter(listAdapter);
        refreshWatchSetList();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.i(TAG, "onCreateOptionsMenu called");
        inflater.inflate(R.menu.watchsets, menu);
        updateMenuOptions();
    }

    private void refreshWatchSetList() {
        listAdapter.clear();
        if (isAdded())
            for (WatchSetInfo info : OsswDatabaseHelper.getInstance(getContext()).listWatchSets(type)) {
                listAdapter.addWatchSet(info);
            }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        updateMenuOptions();
    }

    private void updateMenuOptions() {
        if (getView() != null) {
            int checkedCount = getListView().getCheckedItemCount();
            setMenuOptions(checkedCount > 0 ? (checkedCount > 1 ? Mode.MULTI : Mode.SINGLE) : Mode.NONE);
        }
    }

    private String buildTitle() {
        switch (type) {
            case WATCH_FACE:
                return getString(R.string.drawer_watch_faces);
            case APPLICATION:
                return getString(R.string.drawer_applications);
            case UTILITY:
                return getString(R.string.drawer_utilities);
        }
        return "";
    }

    private void setMenuOptions(Mode mode) {
        if (!isAdded())
            return;
        int checkedCount = getListView().getCheckedItemCount();
        boolean hideTitle = checkedCount > 0 && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        setTitle(hideTitle ? "" : buildTitle());
        Menu menu = ((MainActivity) getActivity()).getToolbar().getMenu();
        MenuItem uploadAction = menu.findItem(R.id.menu_upload_to_watch);
        MenuItem itemsRemoveAction = menu.findItem(R.id.menu_items_remove);
        MenuItem previewAction = menu.findItem(R.id.menu_preview);
        switch (mode) {
            case MULTI:
                uploadAction.setVisible(false);
                previewAction.setVisible(false);
                itemsRemoveAction.setVisible(true);
                break;
            case SINGLE:
                uploadAction.setVisible(true);
                previewAction.setVisible(true);
                itemsRemoveAction.setVisible(true);
                break;
            case NONE:
                uploadAction.setVisible(false);
                previewAction.setVisible(false);
                itemsRemoveAction.setVisible(false);
                break;
        }
    }

    private void resetSelection() {
        ListView listView = getListView();
        listView.clearChoices();
        listView.requestLayout();
        setMenuOptions(Mode.NONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        OsswDatabaseHelper db = OsswDatabaseHelper.getInstance(getContext());
        if (id == R.id.menu_import) {
            showFileChooser();
            resetSelection();
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
            resetSelection();
            return true;
        } else if (id == R.id.menu_preview) {
            SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
            int count = getListView().getCount();
            for (int i = 0; i < count; i++) {
                if (sparseBooleanArray.get(i) && isAdded()) {
                    WatchSetInfo info = (WatchSetInfo) getListAdapter().getItem(i);
                    Intent intent = new Intent(getContext(), WatchSetPreviewActivity.class);
                    intent.putExtra("id", info.getId());
                    intent.putExtra("type", type);
                    startActivity(intent);
                    resetSelection();
                    return true;
                }
            }
        } else if (id == R.id.menu_upload_to_watch) {
            SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
            int count = getListView().getCount();
            for (int i = 0; i < count; i++) {
                if (sparseBooleanArray.get(i) && isAdded()) {
                    try {
                        WatchSetInfo info = (WatchSetInfo) getListAdapter().getItem(i);
                        String source = db.getWatchSetSourceById(info.getId());
                        Integer extWatchSetId = db.getExtWatchSetId(info.getId());
                        CompiledWatchSet compiledWatchSet = new WatchSetCompiler(getContext()).compile(source, extWatchSetId);
                        OsswService osswBleService = OsswService.getInstance();
                        if (osswBleService != null) {
                            osswBleService.uploadData(buildDataType(type), compiledWatchSet.getName(), compiledWatchSet.getWatchData());
                        }
                    } catch (Exception e) {
                        toastHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), getString(R.string.toast_invalid_file), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    resetSelection();
                    return true;
                }
            }
        }
        return super.onOptionsItemSelected(item);
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
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(getContext(), "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Log.i(TAG, "result code: " + resultCode);
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == Activity.RESULT_OK && isAdded()) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    //Log.i(TAG, "File Uri: " + uri.toString());
                    Intent i = new Intent(getContext(), WatchSetPreviewActivity.class);
                    i.putExtra("uri", uri.toString());
                    i.putExtra("type", type);
                    startActivityForResult(i, WATCH_FACE_IMPORTED);
                }
                break;
            case WATCH_FACE_IMPORTED:
                if (resultCode == Activity.RESULT_OK) {
                    refreshWatchSetList();
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

    public void setTitle(String title) {
        getActivity().setTitle(title);
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