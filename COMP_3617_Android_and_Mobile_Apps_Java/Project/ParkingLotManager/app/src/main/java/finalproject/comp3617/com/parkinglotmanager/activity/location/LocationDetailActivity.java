package finalproject.comp3617.com.parkinglotmanager.activity.location;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.database.LocationDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.Location;

public class LocationDetailActivity extends BaseActivity {

    @Bind(R.id.locationCodeEditText)
    EditText locationCodeEditText;
    @Bind(R.id.locationOrderCodeEditText)
    EditText locationOrderCodeEditText;
    @Bind(R.id.locationIsMultiCapacityCheckBox)
    CheckBox locationIsMultiCapacityCheckBox;
    @Bind(R.id.saveButton)
    Button saveButton;
    @Bind(R.id.cancelButton)
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        ButterKnife.bind(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = new Location();
                location.setCode(locationCodeEditText.getText().toString());
                location.setOrderCode(locationOrderCodeEditText.getText().toString());
                location.setIsMultiCapacity(locationIsMultiCapacityCheckBox.isChecked());
                LocationDBHelper.getInstance(getApplicationContext()).addLocation(location);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
