package finalproject.comp3617.com.parkinglotmanager.activity.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.database.VehicleDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Location;
import finalproject.comp3617.com.parkinglotmanager.model.Vehicle;
import finalproject.comp3617.com.parkinglotmanager.util.DateHelper;
import zxing.IntentIntegrator;
import zxing.IntentResult;

public class DashboardDetailActivity extends BaseActivity {

    @Bind(R.id.backButton)
    Button backButton;
    @Bind(R.id.locationCodeTextView)
    TextView locationCodeTextView;
    @Bind(R.id.vehicleTypeEditText)
    EditText vehicleTypeEditText;
    @Bind(R.id.vehicleMakeEditText)
    EditText vehicleMakeEditText;
    @Bind(R.id.vehicleModelEditText)
    EditText vehicleModelEditText;
    @Bind(R.id.vehicleLicensePlateEditText)
    EditText vehicleLicensePlateEditText;
    @Bind(R.id.vehicleTagStatusTextView)
    TextView vehicleTagStatusTextView;
    @Bind(R.id.vehicleArrivalTimeTextView)
    TextView vehicleArrivalTimeTextView;
    @Bind(R.id.tagButton)
    Button tagButton;
    @Bind(R.id.checkInButton)
    Button checkInButton;
    @Bind(R.id.checkOutButton)
    Button checkOutButton;
    @Bind(R.id.saveButton)
    Button saveButton;

    private Location location;
    private Vehicle vehicle;
    private boolean isCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_detail);
        ButterKnife.bind(this);

        isCheckOut = false;
        getDataFromIntent();
        initializeViews();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        location = intent.getParcelableExtra(Location.LOCATION_OBJECT);
        vehicle = intent.getParcelableExtra(Vehicle.VEHICLE_OBJECT);
    }

    private void initializeViews()
    {
        locationCodeTextView.setText(location.getCode());

        tagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(DashboardDetailActivity.this);
                scanIntegrator.initiateScan();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        checkInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableVehicleInfo();
                checkInButton.setVisibility(View.INVISIBLE);
                saveButton.setVisibility(View.VISIBLE);
                vehicle = new Vehicle();
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckOut = true;
                IntentIntegrator scanIntegrator = new IntentIntegrator(DashboardDetailActivity.this);
                scanIntegrator.initiateScan();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInputVehicleInfoValid()) {
                    vehicle.setType(vehicleTypeEditText.getText().toString());
                    vehicle.setMake(vehicleMakeEditText.getText().toString());
                    vehicle.setModel(vehicleModelEditText.getText().toString());
                    vehicle.setLicensePlate(vehicleLicensePlateEditText.getText().toString());
                    vehicle.setArrivalTime(new Date());
                    vehicle.setLocationId(location.getId());
                    VehicleDBHelper.getInstance(getApplicationContext()).checkInVehicle(vehicle);
                    finish();
                }
            }
        });

        updateDisplay();
    }

    private void updateDisplay() {
        disableVehicleInfo();
        if(vehicle == null) {
            checkInButton.setVisibility(View.VISIBLE);
            checkOutButton.setVisibility(View.INVISIBLE);
        } else {
            checkInButton.setVisibility(View.INVISIBLE);
            checkOutButton.setVisibility(View.VISIBLE);
            fillInVehicleInfo();
        }
    }

    private void fillInVehicleInfo() {
        vehicleTypeEditText.setText(vehicle.getType());
        vehicleMakeEditText.setText(vehicle.getMake());
        vehicleModelEditText.setText(vehicle.getMake());
        vehicleLicensePlateEditText.setText(vehicle.getLicensePlate());
        if (vehicle.getScannableId() == null) {
            vehicleTagStatusTextView.setText(getString(R.string.not_assigned));
        } else {
            vehicleTagStatusTextView.setText(getString(R.string.assigned));
        }
        if (vehicle.getArrivalTime() != null) {
            vehicleArrivalTimeTextView.setText(DateHelper.getDateTimeString(vehicle.getArrivalTime()));
        }
    }

    private void disableVehicleInfo() {
        vehicleTypeEditText.setEnabled(false);
        vehicleMakeEditText.setEnabled(false);
        vehicleModelEditText.setEnabled(false);
        vehicleLicensePlateEditText.setEnabled(false);
        vehicleTagStatusTextView.setVisibility(View.INVISIBLE);
        vehicleArrivalTimeTextView.setVisibility(View.INVISIBLE);
    }

    private void enableVehicleInfo() {
        vehicleTypeEditText.setEnabled(true);
        vehicleMakeEditText.setEnabled(true);
        vehicleModelEditText.setEnabled(true);
        vehicleLicensePlateEditText.setEnabled(true);
        vehicleTagStatusTextView.setVisibility(View.VISIBLE);
        vehicleArrivalTimeTextView.setVisibility(View.VISIBLE);
    }

    private boolean isInputVehicleInfoValid() {
        if (vehicleTypeEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle type is empty!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (vehicleMakeEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle make is empty!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (vehicleModelEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle model is empty!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (vehicleLicensePlateEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vehicle plate is empty!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!vehicleTagStatusTextView.getText().toString().equals(getString(R.string.assigned))) {
            Toast.makeText(this, "Vehicle tag is not assigned!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null) {
            String tagId = scanningResult.getContents();
            if (!isCheckOut) {
                vehicleTagStatusTextView.setText(getString(R.string.assigned));
                vehicle.setScannableId(tagId);
            } else {
                if (tagId.equals(vehicle.getScannableId())) {
                    vehicle.setLocationId(0);
                    vehicle.setDepartureTime(new Date());
                    vehicle.setScannableId(null);
                    VehicleDBHelper.getInstance(getApplicationContext()).checkOutVehicle(vehicle);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.tag_does_not_match), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.no_data), Toast.LENGTH_LONG).show();
        }


    }
}
