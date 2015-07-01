package com.althink.android.ossw.watchsets;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class WatchSetsFragment extends Fragment {

    private final static String TAG = WatchSetsFragment.class.getSimpleName();
    private LayoutInflater mInflator;
    private WatchEmulator emulator;
    private CompiledWatchSet watchSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflator = inflater;

        final View view = inflater.inflate(R.layout.fragment_watchsets, container, false);
        WatchView watchView = (WatchView) view.findViewById(R.id.watch_emulator_screen_view);
        emulator = watchView.getWatchEmulator();

        view.findViewById(R.id.upload_watchset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OsswService osswBleService = ((MainActivity) getActivity()).getOsswBleService();
                if (watchSet != null) {
                    osswBleService.uploadData(UploadDataType.WATCHSET, watchSet.getWatchData());
                }
            }
        });

        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_up), EmulatorButton.UP);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_down), EmulatorButton.DOWN);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_select), EmulatorButton.SELECT);
        registerClickHandlers(view.findViewById(R.id.watch_emulator_button_back), EmulatorButton.BACK);

        view.findViewById(R.id.load_watchset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder text = new StringBuilder();
                try {
                    File sdcard = Environment.getExternalStorageDirectory();
                    File file = new File(sdcard, "watchmatch3.json");

                    watchSet = parseWatchSet(file);

                    Log.i(TAG, "File " + file.getPath() + " successfully loaded, watchSetId: " + watchSet.getId());

                    //((MainActivity) getActivity()).getOsswBleService().setWatchOperationContext(watchSet.getWatchContext());

                    ((MainActivity) getActivity()).getOsswBleService().registerWatchSet(watchSet);

                    WatchSetEmulatorModel model = emulator.parseWatchSet(watchSet.getWatchData());
                    emulator.showWatchSet(model);
                } catch (KnownParseError e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), getString(R.string.toast_invalid_file), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
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
        String fileData = loadFileData(file);
        return new WatchSetCompiler(getActivity()).compile(fileData);
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
    public void onDestroy() {
        super.onDestroy();
    }

}