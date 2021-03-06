package com.althink.android.ossw.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.althink.android.ossw.service.WatchOperationContext;
import com.althink.android.ossw.watchsets.WatchSetType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 08/11/15.
 */
public class OsswDatabaseHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "OsswDB";
    private static final int DATABASE_VERSION = 2;
    private static OsswDatabaseHelper sInstance;

    // ...

    public static synchronized OsswDatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new OsswDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private OsswDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {

        if (isTableExists(db, "watchSets")) {
            // migration from not versioned database to v2
            db.execSQL("ALTER TABLE watchSets ADD COLUMN type TEXT NOT NULL DEFAULT 'WATCH_FACE'");
        } else {
            db.execSQL("CREATE TABLE IF NOT EXISTS watchSets(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL,source BLOB NOT NULL, context BLOB NOT NULL, extWatchSetId INTEGER NOT NULL, type TEXT NOT NULL DEFAULT 'WATCH_FACE');");
        }
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public WatchOperationContext getWatchContextByExtWatchSetId(int extWatchSetId) {
        String sql = "SELECT context from watchSets WHERE extWatchSetId = ?";
        Cursor cursor = getReadableDatabase().rawQuery(sql, new String[]{Integer.toString(extWatchSetId)});
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
        Cursor cursor = getReadableDatabase().rawQuery(sql, new String[]{Integer.toString(id)});
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
        Cursor cursor = getReadableDatabase().rawQuery(sql, new String[]{Integer.toString(id)});
        boolean exists = cursor.moveToFirst();
        Integer extWatchSetId = null;
        if (exists) {
            extWatchSetId = cursor.getInt(0);
        }
        cursor.close();
        return extWatchSetId;
    }

    public List<WatchSetInfo> listWatchSets(WatchSetType type) {
        LinkedList<WatchSetInfo> list = new LinkedList<>();

        String sql = "SELECT id, name from watchSets where type = ?";
        Cursor cursor = getReadableDatabase().rawQuery(sql, new String[]{type.name()});

        while (cursor.moveToNext()) {
            list.add(new WatchSetInfo(cursor.getInt(0), cursor.getString(1)));
        }
        cursor.close();
        return list;
    }

    public void addWatchSet(WatchSetType type, String name, String source, WatchOperationContext watchContext, int extWatchSetId) {

        Gson gson = new GsonBuilder().create();
        byte[] contextData = gson.toJson(watchContext).getBytes();

        String sql = "UPDATE watchSets SET source=?, context=?, extWatchSetId=? WHERE name = ? and type = ?";
        SQLiteDatabase database = getWritableDatabase();
        SQLiteStatement updateStmt = database.compileStatement(sql);
        updateStmt.clearBindings();
        updateStmt.bindBlob(1, source.getBytes());
        updateStmt.bindBlob(2, contextData);
        updateStmt.bindLong(3, extWatchSetId);
        updateStmt.bindString(4, name);
        updateStmt.bindString(5, type.name());

        boolean success = updateStmt.executeUpdateDelete() > 0;

        if (success) {
            //Log.i(TAG, "Watchset \"" + name + "\" successfully updated");
        } else {
            sql = "INSERT INTO watchSets (id, type, name, source, context, extWatchSetId) VALUES($next_id,?,?,?,?,?)";
            SQLiteStatement insertStmt = database.compileStatement(sql);
            insertStmt.clearBindings();
            insertStmt.bindString(2, type.name());
            insertStmt.bindString(3, name);
            insertStmt.bindBlob(4, source.getBytes());
            insertStmt.bindBlob(5, contextData);
            insertStmt.bindLong(6, extWatchSetId);
            insertStmt.executeInsert();
            //Log.i(TAG, "Watchset \"" + name + "\" successfully created");
        }

    }

    public boolean deleteWatchSet(int watchSetInternalId) {
        String sql = "DELETE FROM watchSets WHERE id = ?";
        SQLiteStatement updateStmt = getWritableDatabase().compileStatement(sql);
        updateStmt.clearBindings();
        updateStmt.bindLong(1, watchSetInternalId);
        return updateStmt.executeUpdateDelete() > 0;
    }

    public boolean isTableExists(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }
}