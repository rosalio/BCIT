package finalproject.comp3617.com.parkinglotmanager.activity.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.adapter.DashboardItemListAdapter;
import finalproject.comp3617.com.parkinglotmanager.database.LocationDBHelper;
import finalproject.comp3617.com.parkinglotmanager.database.VehicleDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Location;
import finalproject.comp3617.com.parkinglotmanager.model.Vehicle;

public class DashboardActivity extends BaseActivity {

    @Bind(R.id.homeIconImageButton)
    ImageButton homeIconImageButton;
    @Bind(R.id.dashboardItemListView)
    ListView dashboardItemListView;

    private DashboardItemListAdapter adapter;
    private Map<Long, Vehicle> locationVehicleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
    }

    private void initializeViews() {
        homeIconImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LocationDBHelper locationDBHelper = LocationDBHelper.getInstance(this);
        VehicleDBHelper vehicleDBHelper = VehicleDBHelper.getInstance(this);

        List<Location> allLocations = locationDBHelper.getLocations();
        List<Vehicle> allVehiclesInFalicity = vehicleDBHelper.getVehiclesInFacility();

        createLocationVehicleMap(allLocations, allVehiclesInFalicity);

        adapter = new DashboardItemListAdapter(this, allLocations, locationVehicleMap);
        dashboardItemListView.setAdapter(adapter);

        dashboardItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = (Location) parent.getItemAtPosition(position);
                Vehicle vehicle = locationVehicleMap.get(new Long(location.getId()));
                openDashboardDetailActivity(location, vehicle);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeViews();
    }

    private void createLocationVehicleMap(List<Location> locations, List<Vehicle> vehicles) {
        locationVehicleMap = new HashMap<Long, Vehicle>();
        for (Location location : locations) {
            long locationId = location.getId();
            Vehicle  vehicle = null;
            for (Vehicle v : vehicles) {
                if (v.getLocationId() == locationId) {
                    vehicle = v;
                    break;
                }
            }
            locationVehicleMap.put(new Long(locationId), vehicle);
        }
    }

}
