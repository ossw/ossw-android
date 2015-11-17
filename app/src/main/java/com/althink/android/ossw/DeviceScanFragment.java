package com.althink.android.ossw;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.ble.ScanRecord;
import com.althink.android.ossw.service.OsswService;

import java.util.ArrayList;
import java.util.List;

public class DeviceScanFragment extends ListFragment {
//    private final static String TAG = DeviceScanFragment.class.getSimpleName();

    private LeDeviceListAdapter mLeDeviceListAdapter;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean mScanning;
    private Handler mHandler;
    private LayoutInflater mInflater;

    private static final int REQUEST_ENABLE_BT = 1;
    // Stops scanning after 5 seconds.
    private static final long SCAN_PERIOD = 5000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializes list view adapter.
        mLeDeviceListAdapter = new LeDeviceListAdapter();
        setListAdapter(mLeDeviceListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater = inflater;
        View v = inflater.inflate(R.layout.fragment_watches, container, false);
        setHasOptionsMenu(true);
        MainActivity faActivity  = (MainActivity)getActivity();
//        Toolbar toolbar = faActivity.getToolbar();
//        faActivity.setSupportActionBar(toolbar);
        faActivity.setTitle(R.string.title_devices);
        mHandler = new Handler();

        // Use this check to determine whether BLE is supported on the device.  Then you can
        // selectively disable BLE-related features.
        if (!faActivity.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(faActivity, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
//            finish();
        }

        // Initializes a Bluetooth adapter.  For API level 18 and above, get a reference to
        // BluetoothAdapter through BluetoothManager.
        final BluetoothManager bluetoothManager =
                (BluetoothManager) faActivity.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        // Checks if Bluetooth is supported on the device.
        if (mBluetoothAdapter == null) {
            Toast.makeText(faActivity, R.string.error_bluetooth_not_supported, Toast.LENGTH_SHORT).show();
        }
        // Ensures Bluetooth is enabled on the device.  If Bluetooth is not currently enabled,
        // fire an intent to display a dialog asking the user to grant permission to enable it.
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        scanLeDevice(true);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.scan, menu);
        updateOptionsMenu(menu);
    }

    private void updateOptionsMenu(Menu menu) {
        if (!mScanning) {
            menu.findItem(R.id.menu_stop).setVisible(false);
            menu.findItem(R.id.menu_scan).setVisible(true);
        } else {
            menu.findItem(R.id.menu_stop).setVisible(true);
            menu.findItem(R.id.menu_scan).setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_scan:
                scanLeDevice(true);
                break;
            case R.id.menu_stop:
                scanLeDevice(false);
                break;
        }
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(stopScanningAfterDelay);
        mHandler.removeCallbacks(rescanAfterDelay);
        scanLeDevice(false);
        mLeDeviceListAdapter.clear();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final OsswService.BluetoothDeviceSummary device = mLeDeviceListAdapter.getDevice(position);
        if (device == null) return;

        if (mScanning) {
            mHandler.removeCallbacks(stopScanningAfterDelay);
            stopLeScan();
            mScanning = false;
        }
        if (device.getSync().equals("CONNECTED")) {
            OsswService.getInstance().disconnect();
            scanLeDevice(true);
        } else {
            OsswService.getInstance().connect(device.getAddress());
            mLeDeviceListAdapter.moveToTop(position);
        }
        //Log.i(TAG, "Return ble address: " +  device.getAddress());
    }

    private Runnable stopScanningAfterDelay = new Runnable() {
        @Override
        public void run() {
            mScanning = false;
            stopLeScan();
            if (getActivity() != null)
                getActivity().invalidateOptionsMenu();
        }
    };

    private Runnable rescanAfterDelay = new Runnable() {
        @Override
        public void run() {
            scanLeDevice(true);
        }
    };

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            mLeDeviceListAdapter.clear();
            // Now fill the top of the list with "paired" devices
            List<OsswService.BluetoothDeviceSummary> activeDevices = OsswService.getInstance().getBondedDevices();
            for (OsswService.BluetoothDeviceSummary aDevice : activeDevices)
                mLeDeviceListAdapter.addDevice(aDevice);
            if (!activeDevices.isEmpty())
                mLeDeviceListAdapter.notifyDataSetChanged();
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(stopScanningAfterDelay, SCAN_PERIOD);
            mScanning = true;
            startLeScan();
        } else {
            mScanning = false;
            stopLeScan();
        }
        getActivity().invalidateOptionsMenu();
    }

    private void startLeScan() {
        mBluetoothAdapter.startLeScan(mLeScanCallback);
    }

    private void stopLeScan() {
        mBluetoothAdapter.stopLeScan(mLeScanCallback);
    }

    // Adapter for holding devices found through scanning.
    private class LeDeviceListAdapter extends BaseAdapter {
        private ArrayList<OsswService.BluetoothDeviceSummary> mLeDevices;

        public LeDeviceListAdapter() {
            super();
            mLeDevices = new ArrayList<>();
        }

        public void addDevice(OsswService.BluetoothDeviceSummary device) {
            if (!mLeDevices.contains(device)) {
                mLeDevices.add(device);
            }
        }

        public void addDevice(BluetoothDevice device, ScanRecord scanRecord, int rssi) {
            if (scanRecord == null || scanRecord.getServiceUuids() == null ||
                    !scanRecord.getServiceUuids().contains(new ParcelUuid(OsswService.OSSW_SERVICE_UUID)) ) {
                return;
            }
            OsswService.BluetoothDeviceSummary bd =
                    new OsswService.BluetoothDeviceSummary(device.getName(), device.getAddress(), "DISCONNECTED", rssi);
            if (!mLeDevices.contains(bd)) {
                mLeDevices.add(bd);
            }
        }

        public OsswService.BluetoothDeviceSummary getDevice(int position) {
            return mLeDevices.get(position);
        }

        public void clear() {
            mLeDevices.clear();
        }

        @Override
        public int getCount() {
            return mLeDevices.size();
        }

        @Override
        public Object getItem(int i) {
            return mLeDevices.get(i);
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
                view = mInflater.inflate(R.layout.listitem_device, null);
                viewHolder = new ViewHolder();
                viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
                viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
                viewHolder.deviceState = (TextView) view.findViewById(R.id.device_state);
                viewHolder.deviceRSSI = (TextView) view.findViewById(R.id.device_rssi);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            OsswService.BluetoothDeviceSummary device = mLeDevices.get(i);
            final String deviceName = device.getName();
            if (deviceName != null && deviceName.length() > 0)
                viewHolder.deviceName.setText(deviceName);
            else
                viewHolder.deviceName.setText(R.string.unknown_device);
            viewHolder.deviceAddress.setText(device.getAddress());
            viewHolder.deviceState.setText(device.getSync());
            if (device.getSync().equals("CONNECTED"))
                viewHolder.deviceState.setTextColor(getResources().getColor(R.color.myConnectedColor));
            else
                viewHolder.deviceState.setTextColor(getResources().getColor(R.color.myDisconnectedColor));
            if (device.getRSSI() != 0)
                viewHolder.deviceRSSI.setText(device.getRSSI() + "dBm");

            return view;
        }

        public void moveToTop(int i) {
            OsswService.BluetoothDeviceSummary bd = mLeDevices.get(i);
            bd.setSync("CONNECTING");
            mLeDevices.remove(i);
            mLeDevices.add(0, bd);
            mLeDeviceListAdapter.notifyDataSetChanged();
            mHandler.postDelayed(rescanAfterDelay, 3000);
        }
    }

    // Device scan callback.
    private BluetoothAdapter.LeScanCallback mLeScanCallback =
            new BluetoothAdapter.LeScanCallback() {

                @Override
                public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLeDeviceListAdapter.addDevice(device, ScanRecord.parseFromBytes(scanRecord), rssi);
                            mLeDeviceListAdapter.notifyDataSetChanged();
                        }
                    });
                }
            };

    static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
        TextView deviceState;
        TextView deviceRSSI;
    }
}