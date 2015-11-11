package com.althink.android.ossw.watchsets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
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
import com.althink.android.ossw.db.OsswDB;
import com.althink.android.ossw.db.WatchSetInfo;
import com.althink.android.ossw.service.OsswService;

import java.util.ArrayList;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchSetsFragment extends ListFragment {

    private final static String TAG = WatchSetsFragment.class.getSimpleName();
    private static final int WATCH_FACE_IMPORTED = 1;
    private LayoutInflater mInflater;
    private static final int FILE_SELECT_CODE = 0;
    private WatchSetsListAdapter listAdapter;
    private OsswDB db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflater = inflater;
        View v = inflater.inflate(R.layout.fragment_watchsets, container, false);
        getActivity().setTitle(R.string.drawer_watchsets);
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new OsswDB(getActivity());
        listAdapter = new WatchSetsListAdapter();
        setListAdapter(listAdapter);
        //Log.i(TAG, "On create");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        Toolbar toolbar = ((MainActivity)getActivity()).getToolbar();
//        toolbar.setNavigationOnClickListener(null);
//                    toolbar.setNavigationIcon(R);
        inflater.inflate(R.menu.watchsets, menu);
        refreshWatchSetList();
//        setMenuOptions(Mode.NONE);
    }

    private void refreshWatchSetList() {
        listAdapter.clear();
        for (WatchSetInfo info : db.listWatchSets()) {
            listAdapter.addWatchSet(info);
        }
        listAdapter.notifyDataSetChanged();
        resetSelection();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        int count = getListView().getCount();
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
        Menu menu = ((MainActivity)getActivity()).getToolbar().getMenu();
        MenuItem uploadAction = menu.findItem(R.id.menu_upload_to_watch);
        MenuItem itemsRemoveAction = menu.findItem(R.id.menu_items_remove);
        switch (mode) {
            case MULTI:
                uploadAction.setVisible(false);
                itemsRemoveAction.setVisible(true);
                break;
            case SINGLE:
                uploadAction.setVisible(true);
                itemsRemoveAction.setVisible(true);
                break;
            case NONE:
                uploadAction.setVisible(false);
                itemsRemoveAction.setVisible(false);
                break;
        }
    }

    private void resetSelection() {
        getListView().clearChoices();
        getListView().requestLayout();
        setMenuOptions(Mode.NONE);
    }

    @Override
    public void onResume() {
        super.onResume();
//        MainActivity activity = ((MainActivity) getActivity());
//        activity.resetBottomToolbar();
//        bottomToolbar = activity.getToolbar();
//        bottomToolbar.getMenu().clear();
//        bottomToolbar.inflateMenu(R.menu.watchsets);
//        bottomToolbar.setVisibility(View.VISIBLE);
//        setMenuOptions(Mode.NONE);
//        refreshWatchSetList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
                    WatchSetInfo info = (WatchSetInfo) getListAdapter().getItem(i);
                    String source = db.getWatchSetSourceById(info.getId());
                    Integer extWatchSetId = db.getExtWatchSetId(info.getId());
                    CompiledWatchSet compiledWatchSet = new WatchSetCompiler(getActivity()).compile(source, extWatchSetId);
                    OsswService osswBleService = OsswService.getInstance();
                    if (osswBleService != null) {
                        osswBleService.uploadData(UploadDataType.WATCHSET, compiledWatchSet.getWatchData());
                    }
                    resetSelection();
                    return true;
                }
            }
        }
        return super.onOptionsItemSelected(item);
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
//                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    WatchSetImportFragment importFragment = new WatchSetImportFragment();
//                    importFragment.setUri(uri);
//                    ft.replace(R.id.fragment_container, importFragment).addToBackStack("Preview fragment");
//                    ft.commit();
                    Intent i = new Intent(getActivity().getApplicationContext(), WatchSetPreviewActivity.class);
                    i.putExtra("uri", uri.toString());
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