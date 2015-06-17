package com.althink.android.ossw.plugins;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 12/06/15.
 */
public class PluginManager {

    private final static String TAG = PluginManager.class.getSimpleName();

    private static final String API_COLUMN_ID = "_id";
    private static final String API_COLUMN_NAME = "name";
    private static final String API_COLUMN_DESCRIPTION = "description";

    private Context context;

    public PluginManager(Context context) {
        this.context = context;
    }

    public List<PluginDefinition> findPlugins() {

        long start = System.currentTimeMillis();
        PackageManager packageManager = context.getPackageManager();
        List<ProviderInfo> providers = packageManager.queryContentProviders(null, 0, PackageManager.GET_META_DATA);

        List<PluginDefinition> plugins = new LinkedList<>();

        for (ProviderInfo provider : providers) {

            if (provider.metaData != null && provider.metaData.containsKey("com.althink.android.ossw.plugin")) {
                PluginDefinition plugin = new PluginDefinition(provider.authority, provider.loadLabel(packageManager).toString());
                fillPluginApi(plugin);
                plugins.add(plugin);
            }
        }

        Log.d(TAG, "plugin scanning time: " + (System.currentTimeMillis() - start));

        return plugins;
    }

    private void fillPluginApi(PluginDefinition plugin) {

        List<PluginPropertyDefinition> properties = new LinkedList<>();
        List<PluginFunctionDefinition> functions = new LinkedList<>();

        try {
            Uri propertiesApiUri = Uri.parse("content://" + plugin.getPluginId() + "/api/properties");
            Cursor cursor = context.getContentResolver().query(propertiesApiUri, null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    properties.add(new PluginPropertyDefinition(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to load plugin properties: " + plugin.getPluginId());
        }
        plugin.setProperties(properties);

        try {
            Uri functionsApiUri = Uri.parse("content://" + plugin.getPluginId() + "/api/functions");
            Cursor cursor = context.getContentResolver().query(functionsApiUri, null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    functions.add(new PluginFunctionDefinition(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to load plugin functions: " + plugin.getPluginId());
        }
        plugin.setFunctions(functions);
    }

}
