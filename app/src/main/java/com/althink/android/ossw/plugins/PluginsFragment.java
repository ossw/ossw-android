package com.althink.android.ossw.plugins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.althink.android.ossw.R;

import java.util.ArrayList;

/**
 * Created by krzysiek on 13/06/15.
 */
public class PluginsFragment extends ListFragment {

    private final static String TAG = PluginsFragment.class.getSimpleName();
    private LayoutInflater mInflator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflator = inflater;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plugins, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PluginManager scanner = new PluginManager(getActivity().getPackageManager());

        PluginListAdapter listAdaptor = new PluginListAdapter();

        for (PluginDefinition plugin : scanner.findPlugins()) {
            listAdaptor.addPlugin(plugin);
        }
        setListAdapter(listAdaptor);

        Log.i(TAG, "On create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "On destroy");
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