package com.althink.android.ossw.watchsets;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.R;
import com.althink.android.ossw.db.OsswDatabaseHelper;
import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.WatchView;
import com.althink.android.ossw.emulator.event.ButtonLongPressedEmulatorEvent;
import com.althink.android.ossw.emulator.event.ButtonPressedEmulatorEvent;
import com.althink.android.ossw.emulator.event.EmulatorButton;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.service.OsswService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchSetImportFragment extends Fragment {

    private final static String TAG = WatchSetImportFragment.class.getSimpleName();
    private WatchEmulator emulator;
    private CompiledWatchSet watchSet;
    private String source;
    private Uri uri;
    private Integer id;
    private WatchSetType type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_watchset_import, container, false);
        setHasOptionsMenu(true);
        final WatchView watchView = (WatchView) view.findViewById(R.id.watch_emulator_screen_view);
        emulator = watchView.getWatchEmulator();

        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_up), EmulatorButton.UP);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_down), EmulatorButton.DOWN);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_select), EmulatorButton.SELECT);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_back), EmulatorButton.BACK);

        return view;
    }

    private boolean loadWatchSet() {
        if (id != null) {
            OsswDatabaseHelper db = OsswDatabaseHelper.getInstance(getActivity());
            source = db.getWatchSetSourceById(id);
        } else if (uri != null) {
            File file = new File(getPath(getActivity(), uri));
            source = loadFileData(file);
        }
        if (source != null && !source.isEmpty()) {
            try {
                watchSet = new WatchSetCompiler(getActivity()).compile(source, null);
                //Log.i(TAG, "File " + file.getPath() + " successfully loaded, watchSetId: " + watchSet.getId());

                WatchSetEmulatorModel model = emulator.parseWatchSet(watchSet);
                emulator.showWatchSet(model);
                ((TextView) getView().findViewById(R.id.watchset_name)).setText(watchSet.getName());
                return true;
            } catch (KnownParseError e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage(), e);
            } catch (Exception e) {
                Toast.makeText(getActivity(), getString(R.string.toast_invalid_file), Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage(), e);
            }
        }
        watchSet = null;
        return false;
    }

    /**
     * Get a file path from a Uri. This will get the the path for Storage Access
     * Framework Documents, as well as the _data field for the MediaStore and
     * other file-based ContentProviders.
     *
     * @param context The context.
     * @param uri     The Uri to query.
     * @author paulburke
     */
    public static String getPath(final Context context, final Uri uri) {
        String path = getDocumentUriPath(context, uri);
        if (path != null) {
            return path;
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    @TargetApi(19)
    private static String getDocumentUriPath(final Context context, final Uri uri) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return null;
        }

        if (isExternalStorageDocument(uri)) {
            final String docId = DocumentsContract.getDocumentId(uri);
            final String[] split = docId.split(":");
            final String type = split[0];

            if ("primary".equalsIgnoreCase(type)) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }

            // TODO handle non-primary volumes
        }
        // DownloadsProvider
        else if (isDownloadsDocument(uri)) {

            final String id = DocumentsContract.getDocumentId(uri);
            final Uri contentUri = ContentUris.withAppendedId(
                    Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

            return getDataColumn(context, contentUri, null, null);
        }
        // MediaProvider
        else if (isMediaDocument(uri)) {
            final String docId = DocumentsContract.getDocumentId(uri);
            final String[] split = docId.split(":");
            final String type = split[0];

            Uri contentUri = null;
            if ("image".equals(type)) {
                contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(type)) {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(type)) {
                contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }

            final String selection = "_id=?";
            final String[] selectionArgs = new String[]{
                    split[1]
            };

            return getDataColumn(context, contentUri, selection, selectionArgs);
        }
        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private void registerClickHandlers(View view, final EmulatorButton button) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emulator.handleEvent(new ButtonPressedEmulatorEvent(button));
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                emulator.handleEvent(new ButtonLongPressedEmulatorEvent(button));
                return true;
            }
        });
    }

    private String loadFileData(File file) {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer content = new StringBuffer();
            char[] buffer = new char[1024];
            int num;
            while ((num = input.read(buffer)) > 0) {
                content.append(buffer, 0, num);
            }

            return content.toString();

        } catch (IOException e) {
            //Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadWatchSet();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_watchset_reload:
                loadWatchSet();
                break;
            case R.id.menu_watchset_import:
                if (watchSet != null) {
                    OsswService service = OsswService.getInstance();
                    if (service != null) {
                        service.createOrUpdateWatchSet(type, watchSet.getName(), source, watchSet.getWatchContext(), watchSet.getId());
                    }
                    getActivity().setResult(Activity.RESULT_OK);
                    getActivity().finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Activity activity = getActivity();
        activity.setTitle(R.string.drawer_preview);
        Toolbar toolbar = (Toolbar)activity.findViewById(R.id.toolbar_actionbar);
        if (id == null && uri != null)
            toolbar.inflateMenu(R.menu.import_watchset);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWatchsetType(WatchSetType type) {
        this.type = type;
    }
}