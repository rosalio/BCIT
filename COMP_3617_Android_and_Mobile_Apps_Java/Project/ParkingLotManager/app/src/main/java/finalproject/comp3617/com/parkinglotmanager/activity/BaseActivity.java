package finalproject.comp3617.com.parkinglotmanager.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import finalproject.comp3617.com.parkinglotmanager.activity.dashboard.DashboardActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.dashboard.DashboardDetailActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.device.DeviceDetailActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.device.DeviceListActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.location.LocationDetailActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.location.LocationListActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.user.UserDetailActivity;
import finalproject.comp3617.com.parkinglotmanager.activity.user.UserListActivity;
import finalproject.comp3617.com.parkinglotmanager.model.Location;
import finalproject.comp3617.com.parkinglotmanager.model.User;
import finalproject.comp3617.com.parkinglotmanager.model.Vehicle;

public class BaseActivity extends FragmentActivity {

    public void openLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    public void openMenuActivity(User user) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(User.USER_OBJECT, user);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    public void openDashboardActivity() {
        Intent i = new Intent(this, DashboardActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openDashboardDetailActivity(Location location, Vehicle vehicle) {
        Intent i = new Intent(this, DashboardDetailActivity.class);
        i.putExtra(Location.LOCATION_OBJECT, location);
        i.putExtra(Vehicle.VEHICLE_OBJECT, vehicle);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openDeviceListActivity() {
        Intent i = new Intent(this, DeviceListActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openDeviceDetailActivity() {
        Intent i = new Intent(this, DeviceDetailActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openUserListActivity() {
        Intent i = new Intent(this, UserListActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openUserDetailActivity() {
        Intent i = new Intent(this, UserDetailActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openLocationListActivity() {
        Intent i = new Intent(this, LocationListActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void openLocationDetailActivity() {
        Intent i = new Intent(this, LocationDetailActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        // Do nothing when back button is pressed.
    }
}
