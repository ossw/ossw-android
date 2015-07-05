package com.althink.android.ossw.watchsets;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;
import com.althink.android.ossw.UploadDataType;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_watchset_import, container, false);
        final WatchView watchView = (WatchView) view.findViewById(R.id.watch_emulator_screen_view);
        emulator = watchView.getWatchEmulator();
//
//        view.findViewById(R.id.upload_watchset).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OsswService osswBleService = ((MainActivity) getActivity()).getOsswBleService();
//                if (watchSet != null) {
//                    ((MainActivity) getActivity()).getOsswBleService().createOrUpdateWatchSet(watchSet.getName(), source, watchSet.getWatchContext(), watchSet.getId());
//                    osswBleService.uploadData(UploadDataType.WATCHSET, watchSet.getWatchData());
//                }
//            }
//        });

        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_up), EmulatorButton.UP);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_down), EmulatorButton.DOWN);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_select), EmulatorButton.SELECT);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_back), EmulatorButton.BACK);

        return view;
    }

    private boolean loadWatchSetFromFile() {
        if (uri != null) {
            try {
                File file = new File(uri.getPath());

                watchSet = parseWatchSet(file);

                Log.i(TAG, "File " + file.getPath() + " successfully loaded, watchSetId: " + watchSet.getId());

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

    public CompiledWatchSet parseWatchSet(File file) {
        source = loadFileData(file);
        return new WatchSetCompiler(getActivity()).compile(source, null);
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
            Log.e(TAG, e.getMessage(), e);
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

        MainActivity activity = ((MainActivity) getActivity());
        activity.resetBottomToolbar();
        Toolbar bottomToolbar = activity.getBottomToolbar();
        bottomToolbar.inflateMenu(R.menu.import_watchset);
        bottomToolbar.setVisibility(View.VISIBLE);

        bottomToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        bottomToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.menu_watchset_reload:
                        loadWatchSetFromFile();
                        break;
                    case R.id.menu_watchset_import:
                        if (watchSet != null) {
                            ((MainActivity) getActivity()).getOsswBleService().createOrUpdateWatchSet(watchSet.getName(), source, watchSet.getWatchContext(), watchSet.getId());
                            getFragmentManager().popBackStack();
                        }
                        break;
                }
                return false;
            }
        });

        loadWatchSetFromFile();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}