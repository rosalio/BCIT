package finalproject.comp3617.com.parkinglotmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.model.Location;
import finalproject.comp3617.com.parkinglotmanager.model.Vehicle;
import finalproject.comp3617.com.parkinglotmanager.util.DateHelper;

public class DashboardItemListAdapter extends ArrayAdapter<Location> {

    private Context context;
    private List<Location> locations;
    private Map<Long, Vehicle> locationVehicleMap;

    public DashboardItemListAdapter(Context context, List<Location> locations, Map<Long, Vehicle> locationVehicleMap) {
        super(context, R.layout.item_dashboard_list_elem, locations);
        this.locations = locations;
        this.locationVehicleMap = locationVehicleMap;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Location location = locations.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View row = null;
        if (convertView != null) {
            row = convertView;
        } else {
            row = layoutInflater.inflate(R.layout.item_dashboard_list_elem, parent, false);
        }

        if (position % 2 == 1) {
            row.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
        }

        TextView locationCodeTextView = (TextView) row.findViewById(R.id.locationCodeTextView);
        RelativeLayout vehicleInfoRelativeLayout = (RelativeLayout) row.findViewById(R.id.vehicleInfoRelativeLayout);
        TextView vehicleTypeTextView = (TextView) row.findViewById(R.id.vehicleTypeTextView);
        TextView vehicleMakeTextView = (TextView) row.findViewById(R.id.vehicleMakeTextView);
        TextView vehicleModelTextView = (TextView) row.findViewById(R.id.vehicleModelTextView);
        TextView vehicleLicensePlateTextView = (TextView) row.findViewById(R.id.vehicleLicensePlateTextView);
        TextView vehicleArrivalTimeTextView = (TextView) row.findViewById(R.id.vehicleArrivalTimeTextView);

        locationCodeTextView.setText(location.getCode());

        Vehicle vehicle = locationVehicleMap.get(new Long(location.getId()));
        if (vehicle != null) {
            vehicleInfoRelativeLayout.setVisibility(View.VISIBLE);
            vehicleTypeTextView.setText(vehicle.getType());
            vehicleMakeTextView.setText(vehicle.getMake());
            vehicleModelTextView.setText(vehicle.getModel());
            vehicleLicensePlateTextView.setText(vehicle.getLicensePlate());
            if (vehicle.getArrivalTime() != null) {
                vehicleArrivalTimeTextView.setText(DateHelper.getDateTimeString(vehicle.getArrivalTime()));
            }

        } else {
            vehicleInfoRelativeLayout.setVisibility(View.INVISIBLE);
        }

        return row;
    }
}
