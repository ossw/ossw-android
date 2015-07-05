package com.althink.android.ossw.watchsets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.DeviceScanActivity;
import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;
import com.althink.android.ossw.SettingsActivity;
import com.althink.android.ossw.db.OsswDB;
import com.althink.android.ossw.db.WatchSetInfo;
import com.althink.android.ossw.plugins.PluginDefinition;

import java.util.ArrayList;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchSetsFragment extends ListFragment {

    private final static String TAG = WatchSetsFragment.class.getSimpleName();
    private LayoutInflater mInflater;
    private static final int FILE_SELECT_CODE = 0;

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

        Log.i(TAG, "On create");
    }

    @Override
    public void onResume() {
        super.onResume();

        OsswDB db = new OsswDB(getActivity());
        WatchSetsListAdapter listAdaptor = new WatchSetsListAdapter();
        for (WatchSetInfo info : db.listWatchSets()) {
            listAdaptor.addWatchSet(info);
        }
        setListAdapter(listAdaptor);

        MainActivity activity = ((MainActivity) getActivity());
        activity.resetBottomToolbar();
        Toolbar bottomToolbar = activity.getBottomToolbar();

        bottomToolbar.inflateMenu(R.menu.watchsets);
        bottomToolbar.setVisibility(View.VISIBLE);

        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menu_import) {
                    showFileChooser();
                    return true;
                }
                return false;
            }
        });
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/json");
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
        Log.i(TAG, "result code: " + resultCode);
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.i(TAG, "File Uri: " + uri.toString());
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    WatchSetImportFragment importFragment = new WatchSetImportFragment();
                    importFragment.setUri(uri);
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

        Log.i(TAG, "On destroy");
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
}