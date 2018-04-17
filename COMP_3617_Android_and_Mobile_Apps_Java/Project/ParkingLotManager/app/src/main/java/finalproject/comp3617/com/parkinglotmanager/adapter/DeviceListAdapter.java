package finalproject.comp3617.com.parkinglotmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.database.DeviceDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Device;

public class DeviceListAdapter extends ArrayAdapter<Device> {

    private Context context;
    private List<Device> devices;

    public DeviceListAdapter(Context context, List<Device> devices) {
        super(context, R.layout.item_device_list_elem, devices);
        this.devices = devices;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Device device = devices.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View row = null;
        if (convertView != null) {
            row = convertView;
        } else {
            row = layoutInflater.inflate(R.layout.item_device_list_elem, parent, false);
        }

//        if (position % 2 == 1) {
//            row.setBackgroundColor(context.getResources().getColor(R.color.gray));
//        }

        TextView deviceIdTextView = (TextView) row.findViewById(R.id.deviceIdTextView);
        TextView deviceIMEITextView = (TextView) row.findViewById(R.id.deviceIMEITextView);
        ImageButton removeDeviceImageButton = (ImageButton) row.findViewById(R.id.removeDeviceImageButton);

        deviceIdTextView.setText(Long.toString(device.getId()));
        deviceIMEITextView.setText(device.getImei());

        removeDeviceImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceDBHelper.getInstance(context).removeDevice(device.getImei());
            }
        });

        return row;
    }
}
