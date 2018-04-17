package finalproject.comp3617.com.parkinglotmanager.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.database.DeviceDBHelper;
import finalproject.comp3617.com.parkinglotmanager.database.UserDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.User;
import zxing.IntentIntegrator;
import zxing.IntentResult;

public class LoginActivity extends BaseActivity {

    private static final int PERMISSION_REQUEST_READ_IMEI = 123;

    @Bind(R.id.scanBadgeImageButton)
    ImageButton scanBadgeImageButton;
    @Bind(R.id.scanBadgeTextView)
    TextView scanBadgeTextView;
    @Bind(R.id.imeiTextView)
    TextView imeiTextView;

    private String deviceIMEI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tryDislayInfo();

        scanBadgeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(LoginActivity.this);
                scanIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null) {
            String badgeId = scanningResult.getContents();
            User user = UserDBHelper.getInstance(this).getUserByBadgeId(badgeId);
            boolean isDeviceRegistered = DeviceDBHelper.getInstance(this).isDeviceRegistered(deviceIMEI);

            if (isDeviceRegistered) {
                if (user != null) {
                    openMenuActivity(user);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.unauthorized_user), Toast.LENGTH_LONG).show();
                }
            } else {
                if (user != null && user.isAdmin()) {
                    openMenuActivity(user);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.unregistered_device), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.no_data), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_READ_IMEI: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    displayDeviceIMEI();
                    return;
                }
            }
        }
    }

    private void tryDislayInfo() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_REQUEST_READ_IMEI);
        } else {
            displayDeviceIMEI();
        }
    }

    private void displayDeviceIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        deviceIMEI = telephonyManager.getDeviceId();
        imeiTextView.setText(String.format("%s: %s", getString(R.string.device_imei), deviceIMEI));
    }

}
