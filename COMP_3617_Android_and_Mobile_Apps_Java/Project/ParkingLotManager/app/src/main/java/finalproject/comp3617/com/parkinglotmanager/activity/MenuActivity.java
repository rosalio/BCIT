package finalproject.comp3617.com.parkinglotmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.model.User;

public class MenuActivity extends BaseActivity {

    @Bind(R.id.dashboardButton)
    Button dashboardButton;
    @Bind(R.id.locationConfigButton)
    Button locationConfigButton;
    @Bind(R.id.deviceConfigButton)
    Button deviceConfigButton;
    @Bind(R.id.userConfigButton)
    Button userConfigButton;
    @Bind(R.id.eventReportButton)
    Button eventReportButton;
    @Bind(R.id.logoutImageButton)
    ImageButton logoutImageButton;
    @Bind(R.id.userNameTextView)
    TextView userNameTextView;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        getDataFromIntent();
        initializeViews();
    }

    private void initializeViews() {
        userNameTextView.setText(String.format("Logged in as %s %s", user.getFirstName(), user.getLastName()));

        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });

        locationConfigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationListActivity();
            }
        });

        deviceConfigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeviceListActivity();
            }
        });

        userConfigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserListActivity();
            }
        });

        logoutImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });

        updateDisplay();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        user = intent.getParcelableExtra(User.USER_OBJECT);
    }

    private void updateDisplay() {
        if (user.isAdmin()) {
            locationConfigButton.setVisibility(View.VISIBLE);
            locationConfigButton.setEnabled(true);
            deviceConfigButton.setVisibility(View.VISIBLE);
            deviceConfigButton.setEnabled(true);
            userConfigButton.setVisibility(View.VISIBLE);
            userConfigButton.setEnabled(true);
        } else {
            locationConfigButton.setVisibility(View.GONE);
            locationConfigButton.setEnabled(false);
            deviceConfigButton.setVisibility(View.GONE);
            deviceConfigButton.setEnabled(false);
            userConfigButton.setVisibility(View.GONE);
            userConfigButton.setEnabled(false);
        }
    }
}
