package com.comp3617.week10.locationservices;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_LOCATION_SERVICES = 100;

    private LocationManager locationManager;
    private Location currentLocation;
    private TextView tvLocation;
    private View rLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        rLayout = findViewById(R.id.rLayout);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
           startListening();
        else 
         requestLocationPermission();
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Snackbar.make(rLayout, "Location access is required for this app.", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    //Request the permission here
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, PERMISSION_REQUEST_LOCATION_SERVICES);
                }
            }).show();
        }
        else {
            Snackbar.make(rLayout, "Location permission is not available.", Snackbar.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION_SERVICES);
        }
    }


    @SuppressWarnings({"ResourceType"})
    private void startListening() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 200, listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_LOCATION_SERVICES) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(rLayout, "Location permission was granted",Snackbar.LENGTH_SHORT).show();
                startListening();
            }
        }
    }

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            currentLocation = location;

            if (currentLocation != null) {
                new GeoCoderTask().execute(currentLocation);
            } else {
                tvLocation.setText("Waiting");
            }

            displayLocation();
            Log.d("MainActivity", "onLocationChanged() is called");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

    };

    private void displayLocation() {
        if (currentLocation != null) {
            tvLocation.setText(String.format("Current Location : %.2f, %.2f", currentLocation.getLongitude(),
                    currentLocation.getLatitude()));
        } else
            tvLocation.setText("Waiting for location update");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(listener);

    }


    private class GeoCoderTask extends AsyncTask<Location, Void, String> {

        private Exception exception;

        @Override
        protected String doInBackground(Location... params) {
            Geocoder gc = new Geocoder(MainActivity.this, Locale.getDefault());
            Location currentLocation = params[0];
            List<Address> addresses = null;
            try {
                Log.d(getClass().getSimpleName(), String.format("Address for %.2f, %.2f", currentLocation.getLongitude(),
                        currentLocation.getLatitude()));
                addresses = gc.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 5);
            } catch (Exception exp) {
                exp.printStackTrace();
                exception = exp;
            }

            Address address;
            if (addresses != null && addresses.size() > 1) {
                address = addresses.get(0);
                return String.format("Address : %s, %s, %s", address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "", address.getLocality(), address.getCountryName());
            } else {
                return "Address not found";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if (exception == null) {
                tvLocation.setText(s);
            } else {
                tvLocation.setText("Exception " + exception.getMessage());
            }
        }
    }



}
