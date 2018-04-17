package finalproject.comp3617.com.parkinglotmanager.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.activity.BaseActivity;
import finalproject.comp3617.com.parkinglotmanager.adapter.UserListAdapter;
import finalproject.comp3617.com.parkinglotmanager.database.UserDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.User;

public class UserListActivity extends BaseActivity {

    @Bind(R.id.userListView)
    ListView userListView;
    @Bind(R.id.backButton)
    Button backButton;
    @Bind(R.id.addButton)
    Button addButton;

    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        UserDBHelper userDBHelper = UserDBHelper.getInstance(this);

        userListAdapter = new UserListAdapter(this, userDBHelper.getUsers());
        userListView.setAdapter(userListAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserDetailActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (userListAdapter != null) {
            List<User> users = UserDBHelper.getInstance(this).getUsers();
            userListAdapter.clear();
            userListAdapter.addAll(users);
            userListAdapter.notifyDataSetChanged();
        }
    }
}
