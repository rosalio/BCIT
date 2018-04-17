package finalproject.comp3617.com.parkinglotmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import finalproject.comp3617.com.parkinglotmanager.R;
import finalproject.comp3617.com.parkinglotmanager.database.UserDBHelper;
import finalproject.comp3617.com.parkinglotmanager.model.User;

public class UserListAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public UserListAdapter(Context context, List<User> users) {
        super(context, R.layout.item_user_list_elem, users);
        this.users = users;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final User user = users.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View row = null;
        if (convertView != null) {
            row = convertView;
        } else {
            row = layoutInflater.inflate(R.layout.item_user_list_elem, parent, false);
        }

        TextView userIdTextView = (TextView) row.findViewById(R.id.userIdTextView);
        TextView userNameTextView = (TextView) row.findViewById(R.id.userNameTextView);
        TextView userBadgeIdTextView = (TextView) row.findViewById(R.id.userBadgeIdTextView);
        CheckBox userIsAdminCheckBox = (CheckBox) row.findViewById(R.id.userIsAdminCheckBox);
        ImageButton removeUserImageButton = (ImageButton) row.findViewById(R.id.removeUserImageButton);

        userIdTextView.setText(Long.toString(user.getId()));
        userNameTextView.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        userBadgeIdTextView.setText(user.getBadgeId());
        userIsAdminCheckBox.setChecked(user.isAdmin());

        removeUserImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDBHelper.getInstance(context).removeUser(user.getBadgeId());
            }
        });

        return row;
    }
}
