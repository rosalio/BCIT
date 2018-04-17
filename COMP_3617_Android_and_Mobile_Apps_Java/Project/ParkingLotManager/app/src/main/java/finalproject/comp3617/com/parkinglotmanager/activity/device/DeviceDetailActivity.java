package finalproject.comp3617.com.parkinglotmanager.activity.device;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.database.DeviceDBHelper;

public class DeviceDetailActivity extends BaseActivity {

    @Bind(R.id.deviceIMEIEditText)
    EditText deviceIMEIEditText;
    @Bind(R.id.saveButton)
    Button saveButton;
    @Bind(R.id.cancelButton)
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);
        ButterKnife.bind(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceIMEI = deviceIMEIEditText.getText().toString();
                DeviceDBHelper.getInstance(getApplicationContext()).addDevice(deviceIMEI);
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
