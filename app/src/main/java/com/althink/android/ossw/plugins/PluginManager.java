package com.althink.android.ossw.plugins;

import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 12/06/15.
 */
public class PluginManager {

    private final static String TAG = PluginManager.class.getSimpleName();

    private PackageManager packageManager;

    public PluginManager(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    public List<PluginDefinition> findPlugins() {

        long start = System.currentTimeMillis();
        List<ProviderInfo> providers = packageManager.queryContentProviders(null, 0, PackageManager.GET_META_DATA);

        List<PluginDefinition> plugins = new LinkedList<>();

        for (ProviderInfo provider : providers) {

            if (provider.metaData != null && provider.metaData.containsKey("com.althink.android.ossw.plugin")) {
                PluginDefinition plugin = new PluginDefinition();
                plugin.setPluginId(provider.authority);
                plugin.setLabel(provider.loadLabel(packageManager).toString());
                plugins.add(plugin);
            }
        }

        Log.d(TAG, "plugin scanning time: " + (System.currentTimeMillis() - start));

        return plugins;
    }

}
