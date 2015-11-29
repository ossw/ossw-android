package com.althink.android.ossw.plugins;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;

import java.util.ArrayList;

/**
 * Created by krzysiek on 13/06/15.
 */
public class PluginsFragment extends ListFragment {

    private final static String TAG = PluginsFragment.class.getSimpleName();
    private LayoutInflater mInflator;
    private PluginListAdapter listAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflator = inflater;
        View v = inflater.inflate(R.layout.fragment_plugins, container, false);
        getActivity().setTitle(R.string.drawer_plugins);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i(TAG, "On create");
        PluginManager scanner = new PluginManager(getActivity());
        listAdaptor = new PluginListAdapter();
        for (PluginDefinition plugin : scanner.findPlugins()) {
            listAdaptor.addPlugin(plugin);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(listAdaptor);
    }

    @Override
    public void onResume() {
        super.onResume();

//        Toolbar bottomToolbar = ((MainActivity) getActivity()).getToolbar();
//        bottomToolbar.setVisibility(View.GONE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Log.i(TAG, "Click: " + position);
        PluginDefinition plugin = (PluginDefinition) getListAdapter().getItem(position);
        Intent configIntent = new Intent();
        configIntent.setAction(plugin.getPluginId() + ".config");

        Log.i(TAG, configIntent.getAction());
        try {
            startActivity(configIntent);
        } catch (Exception e) {
            Toast.makeText(getActivity(), getString(R.string.toast_nothing_to_configure), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Log.i(TAG, "On destroy");
    }

    private class PluginListAdapter extends BaseAdapter {
        private ArrayList<PluginDefinition> mPlugins;

        public PluginListAdapter() {
            super();
            mPlugins = new ArrayList<PluginDefinition>();
        }

        public void addPlugin(PluginDefinition plugin) {
            mPlugins.add(plugin);
        }

        public PluginDefinition getPlugin(int position) {
            return mPlugins.get(position);
        }

        public void clear() {
            mPlugins.clear();
        }

        @Override
        public int getCount() {
            return mPlugins.size();
        }

        @Override
        public Object getItem(int i) {
            return mPlugins.get(i);
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
                view = mInflator.inflate(R.layout.listitem_plugin, null);
                viewHolder = new ViewHolder();
                viewHolder.pluginName = (TextView) view.findViewById(R.id.plugin_name);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            PluginDefinition plugin = mPlugins.get(i);
            final String pluginName = plugin.getLabel();
            viewHolder.pluginName.setText(pluginName);
            return view;
        }
    }

    static class ViewHolder {
        TextView pluginName;
    }
}