package finalproject.comp3617.com.parkinglotmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.database.LocationDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Location;

public class LocationListAdapter extends ArrayAdapter<Location> {

    private Context context;
    private List<Location> locations;

    public LocationListAdapter(Context context, List<Location> locations) {
        super(context, R.layout.item_location_list_elem, locations);
        this.locations = locations;
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
            row = layoutInflater.inflate(R.layout.item_location_list_elem, parent, false);
        }

        TextView locationIdTextView = (TextView) row.findViewById(R.id.locationIdTextView);
        TextView locationCodeTextView = (TextView) row.findViewById(R.id.locationCodeTextView);
        TextView locationOrderCodeTextView = (TextView) row.findViewById(R.id.locationOrderCodeTextView);
        CheckBox locationIsMultiCapacityCheckBox = (CheckBox) row.findViewById(R.id.locationIsMultiCapacityCheckBox);
        ImageButton removeLocationImageButton = (ImageButton) row.findViewById(R.id.removeLocationImageButton);

        locationIdTextView.setText(Long.toString(location.getId()));
        locationCodeTextView.setText(location.getCode());
        locationOrderCodeTextView.setText(location.getOrderCode());
        locationIsMultiCapacityCheckBox.setChecked(location.isMultiCapacity());

        removeLocationImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationDBHelper.getInstance(context).removeLocation(location.getId());
            }
        });

        return row;
    }
}
