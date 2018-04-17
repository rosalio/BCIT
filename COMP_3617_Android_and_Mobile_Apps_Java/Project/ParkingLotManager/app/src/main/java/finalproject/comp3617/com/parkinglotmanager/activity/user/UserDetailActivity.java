package finalproject.comp3617.com.parkinglotmanager.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.database.UserDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.User;

public class UserDetailActivity extends BaseActivity {

    @Bind(R.id.userFirstNameEditText)
    EditText userFirstNameEditText;
    @Bind(R.id.userLastNameEditText)
    EditText userLastNameEditText;
    @Bind(R.id.userBadgeIdEditText)
    EditText userBadgeIdEdittext;
    @Bind(R.id.userIsAdminCheckBox)
    CheckBox userIsAdminCheckBox;
    @Bind(R.id.saveButton)
    Button saveButton;
    @Bind(R.id.cancelButton)
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setFirstName(userFirstNameEditText.getText().toString());
                user.setLastName(userLastNameEditText.getText().toString());
                user.setBadgeId(userBadgeIdEdittext.getText().toString());
                user.setIsAdmin(userIsAdminCheckBox.isChecked());
                UserDBHelper.getInstance(getApplicationContext()).addUser(user);
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
