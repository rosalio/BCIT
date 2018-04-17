package finalproject.comp3617.com.parkinglotmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

import finalproject.comp3617.com.parkinglotmanager.model.User;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "parking_lot_manager.db";
    private static final int DB_VERSION = 1;

    private static final String USER_TABLE = "User";

    private static final String USER_COL_ID = BaseColumns._ID;
    private static final String USER_COL_FIRSTNAME = "firstName";
    private static final String USER_COL_LASTNAME = "lastName";
    private static final String USER_COL_BADGEID = "badgeId";
    private static final String USER_COL_ISADMIN = "isAdmin";

    private static final String USER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS User ( " +
            USER_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USER_COL_FIRSTNAME + " TEXT NOT NULL, " +
            USER_COL_LASTNAME + " TEXT NOT NULL, " +
            USER_COL_BADGEID + " TEXT NOT NULL, " +
            USER_COL_ISADMIN + " BIT(1) NOT NULL DEFAULT 0);";

    private static UserDBHelper INSTANCE;

    public static UserDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UserDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private UserDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(USER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public ArrayList<User> getUsers() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s", USER_TABLE);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    users.add(getUserFromCursor(c));
                }
            }

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return users;
    }

    private static User getUserFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        User user = new User();
        user.setId(c.getLong(c.getColumnIndex(UserDBHelper.USER_COL_ID)));
        user.setFirstName(c.getString(c.getColumnIndex(UserDBHelper.USER_COL_FIRSTNAME)));
        user.setLastName(c.getString(c.getColumnIndex(UserDBHelper.USER_COL_LASTNAME)));
        user.setBadgeId(c.getString(c.getColumnIndex(UserDBHelper.USER_COL_BADGEID)));
        user.setIsAdmin(c.getInt(c.getColumnIndex(UserDBHelper.USER_COL_ISADMIN)) > 0);
        return user;
    }

    public boolean removeUser(String badgeId) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(USER_TABLE, String.format("%s = %s", USER_COL_BADGEID, badgeId), null) > 0;
    }

    public void addUser(User newUser) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_COL_FIRSTNAME, newUser.getFirstName());
        cv.put(USER_COL_LASTNAME, newUser.getLastName());
        cv.put(USER_COL_BADGEID, newUser.getBadgeId());
        cv.put(USER_COL_ISADMIN, newUser.isAdmin());

        db.insert(USER_TABLE, null, cv);
    }

    public User getUserByBadgeId(String badgeId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        User user = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE %s=\"%s\"", USER_TABLE, USER_COL_BADGEID, badgeId);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                c.moveToNext();
                user = getUserFromCursor(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return user;
    }


}
