package com.althink.android.ossw.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.althink.android.ossw.service.WatchOperationContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 04/07/15.
 */
public class OsswDB {

    private final static String TAG = OsswDB.class.getSimpleName();

    private Context context;
    private SQLiteDatabase db;

    public OsswDB(Context context) {
        this.context = context;

        db = context.openOrCreateDatabase("OsswDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS watchSets(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL,source BLOB NOT NULL, context BLOB NOT NULL, extWatchSetId INTEGER NOT NULL);");

    }

    public WatchOperationContext getWatchContextByExtWatchSetId(int extWatchSetId) {
        String sql = "SELECT context from watchSets WHERE extWatchSetId = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{Integer.toString(extWatchSetId)});
        boolean exists = cursor.moveToFirst();
        WatchOperationContext ctx = null;
        if (exists) {
            Gson gson = new GsonBuilder().create();
            ctx = gson.fromJson(new String(cursor.getBlob(0)), WatchOperationContext.class);
        }
        cursor.close();
        return ctx;
    }

    public String getWatchSetSourceById(int id) {
        String sql = "SELECT source from watchSets WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{Integer.toString(id)});
        boolean exists = cursor.moveToFirst();
        String source = null;
        if (exists) {
            source = new String(cursor.getBlob(0));
        }
        cursor.close();
        return source;
    }

    public Integer getExtWatchSetId(int id) {
        String sql = "SELECT extWatchSetId from watchSets WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{Integer.toString(id)});
        boolean exists = cursor.moveToFirst();
        Integer extWatchSetId = null;
        if (exists) {
            extWatchSetId = cursor.getInt(0);
        }
        cursor.close();
        return extWatchSetId;
    }

    public List<WatchSetInfo> listWatchSets() {
        LinkedList<WatchSetInfo> list = new LinkedList<>();

        String sql = "SELECT id, name from watchSets";
        Cursor cursor = db.rawQuery(sql, new String[]{});

        while (cursor.moveToNext()) {
            list.add(new WatchSetInfo(cursor.getInt(0), cursor.getString(1)));
        }
        cursor.close();
        return list;
    }

    public void addWatchSet(String name, String source, WatchOperationContext watchContext, int extWatchSetId) {

        Gson gson = new GsonBuilder().create();
        byte[] contextData = gson.toJson(watchContext).getBytes();

        String sql = "UPDATE watchSets SET source=?, context=?, extWatchSetId=? WHERE name = ?";
        SQLiteStatement updateStmt = db.compileStatement(sql);
        updateStmt.clearBindings();
        updateStmt.bindBlob(1, source.getBytes());
        updateStmt.bindBlob(2, contextData);
        updateStmt.bindLong(3, extWatchSetId);
        updateStmt.bindString(4, name);

        boolean success = updateStmt.executeUpdateDelete() > 0;

        if (success) {
            //Log.i(TAG, "Watchset \"" + name + "\" successfully updated");
        } else {
            sql = "INSERT INTO watchSets (id, name, source, context, extWatchSetId) VALUES($next_id,?,?,?,?)";
            SQLiteStatement insertStmt = db.compileStatement(sql);
            insertStmt.clearBindings();
            insertStmt.bindString(2, name);
            insertStmt.bindBlob(3, source.getBytes());
            insertStmt.bindBlob(4, contextData);
            insertStmt.bindLong(5, extWatchSetId);
            insertStmt.executeInsert();
            //Log.i(TAG, "Watchset \"" + name + "\" successfully created");
        }

    }

    public boolean deleteWatchSet(int watchSetInternalId) {
        String sql = "DELETE FROM watchSets WHERE id = ?";
        SQLiteStatement updateStmt = db.compileStatement(sql);
        updateStmt.clearBindings();
        updateStmt.bindLong(1, watchSetInternalId);
        return updateStmt.executeUpdateDelete() > 0;
    }

//    private boolean checkWatchSetExists(String name) {
//        String sql = "SELECT 1 from watchSets WHERE name = ?";
//        Cursor cursor = db.rawQuery(sql, new String[]{});
//        boolean exists = cursor.moveToFirst();
//        cursor.close();
//        return exists;
//    }
}
