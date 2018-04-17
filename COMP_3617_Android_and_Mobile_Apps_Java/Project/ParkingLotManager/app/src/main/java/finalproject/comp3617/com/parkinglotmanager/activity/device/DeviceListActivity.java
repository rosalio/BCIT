package finalproject.comp3617.com.parkinglotmanager.activity.device;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.adapter.DeviceListAdapter;
import finalproject.comp3617.com.parkinglotmanager.database.DeviceDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Device;

public class DeviceListActivity extends BaseActivity {

    @Bind(R.id.deviceListView)
    ListView deviceListView;
    @Bind(R.id.backButton)
    Button backButton;
    @Bind(R.id.addButton)
    Button addButton;

    private DeviceListAdapter deviceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        ButterKnife.bind(this);

        DeviceDBHelper deviceDBHelper = DeviceDBHelper.getInstance(this);

        deviceListAdapter = new DeviceListAdapter(this, deviceDBHelper.getDevices());
        deviceListView.setAdapter(deviceListAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeviceDetailActivity();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (deviceListAdapter != null) {
            List<Device> devices = DeviceDBHelper.getInstance(this).getDevices();
            deviceListAdapter.clear();
            deviceListAdapter.addAll(devices);
            deviceListAdapter.notifyDataSetChanged();
        }
    }
}
