package com.althink.android.ossw.utils;

import android.os.RemoteException;
import android.util.Log;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.service.FitnessSensorService;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OsswSensorService extends FitnessSensorService {
    private static final String TAG = OsswSensorService.class.getName();
    FitnessSensorServiceRequest mRequest;

    @Override
    public void onCreate() {
        super.onCreate();
        // 1. Initialize your software sensor(s).
        // 2. Create DataSource representations of your software sensor(s).
        // 3. Initialize some data structure to keep track of a registration for each sensor.
    }

    @Override
    public List<DataSource> onFindDataSources(List<DataType> dataTypes) {
        // 1. Find which of your software sensors provide the data types requested.
        // 2. Return those as a list of DataSource objects.
        Log.d(TAG, "Google fit onFindDataSources");
        Log.d(TAG, dataTypes.toString());
        List<DataSource> sources = new ArrayList<>();

        try {
            DataSource src = new DataSource.Builder()
                    .setDataType(DataType.TYPE_STEP_COUNT_DELTA)
                    .setName("OSSW pedometer sensor")
                    .setType(DataSource.TYPE_RAW)
//                        .setDevice(new Device("ABC", "ZYX BT", mac, 0))
                    .build();
            sources.add(src);
        } catch (Exception e) {
            Log.e(TAG, "onFindDataSources", e);
        }

        return sources;
    }

    @Override
    public boolean onRegister(FitnessSensorServiceRequest request) {
        // 1. Determine which sensor to register with request.getDataSource().
        // 2. If a registration for this sensor already exists, replace it with this one.
        // 3. Keep (or update) a reference to the request object.
        // 4. Configure your sensor according to the request parameters.
        // 5. When the sensor has new data, deliver it to the platform by calling
        //    request.getDispatcher().publish(List<DataPoint> dataPoints)
        mRequest = request;
        Log.d(TAG, "Google fit request stored");
        FunctionHandler.registerSensorService(this);
        return true;
    }

    @Override
    public boolean onUnregister(DataSource dataSource) {
        // 1. Configure this sensor to stop delivering data to the platform
        // 2. Discard the reference to the registration request object
        FunctionHandler.unregisterSensorService();
        return true;
    }

    public void addPedometerDelta(byte[] data) {
        if (data.length != 2 || mRequest == null)
            return;
        int value = data[0] << 8 | data[1] & 0xff;
        List<DataPoint> dataPoints = new ArrayList<>();
        DataPoint dp = DataPoint.create(mRequest.getDataSource());
        dp.setIntValues(value);
        dp.setTimestamp(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        dataPoints.add(dp);
        try {
            Log.d(TAG, "Publishing data points: " + value);
            mRequest.getDispatcher().publish(dataPoints);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
