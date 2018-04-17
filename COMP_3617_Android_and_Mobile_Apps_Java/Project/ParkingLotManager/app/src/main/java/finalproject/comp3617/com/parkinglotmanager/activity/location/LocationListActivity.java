package finalproject.comp3617.com.parkinglotmanager.activity.location;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.adapter.LocationListAdapter;
import finalproject.comp3617.com.parkinglotmanager.database.LocationDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Location;

public class LocationListActivity extends BaseActivity {

    @Bind(R.id.locationListView)
    ListView locationListView;
    @Bind(R.id.backButton)
    Button backButton;
    @Bind(R.id.addButton)
    Button addButton;

    private LocationListAdapter locationListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        ButterKnife.bind(this);

        LocationDBHelper locationDBHelper = LocationDBHelper.getInstance(this);

        locationListAdapter = new LocationListAdapter(this, locationDBHelper.getLocations());
        locationListView.setAdapter(locationListAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationDetailActivity();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (locationListAdapter != null) {
            List<Location> locations = LocationDBHelper.getInstance(this).getLocations();
            locationListAdapter.clear();
            locationListAdapter.addAll(locations);
            locationListAdapter.notifyDataSetChanged();
        }
    }
}
