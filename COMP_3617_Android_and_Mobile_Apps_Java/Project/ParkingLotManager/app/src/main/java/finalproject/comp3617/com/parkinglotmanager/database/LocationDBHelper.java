package finalproject.comp3617.com.parkinglotmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

import finalproject.comp3617.com.parkinglotmanager.model.Location;

public class LocationDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "parking_lot_manager.db";
    private static final int DB_VERSION = 1;

    private static final String LOCATION_TABLE = "Location";

    private static final String LOCATION_COL_ID = BaseColumns._ID;
    private static final String LOCATION_COL_CODE = "code";
    private static final String LOCATION_COL_ORDERCODE = "orderCode";
    private static final String LOCATION_COL_ISMULTICAPACITY = "isMultiCapacity";

    private static final String LOCATION_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS Location ( " +
            LOCATION_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LOCATION_COL_CODE + " TEXT NOT NULL, " +
            LOCATION_COL_ORDERCODE + " TEXT NOT NULL, " +
            LOCATION_COL_ISMULTICAPACITY + " BIT(1) NOT NULL DEFAULT 0);";

    private static LocationDBHelper INSTANCE;

    public static LocationDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocationDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private LocationDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(LOCATION_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LOCATION_TABLE);
        onCreate(db);
    }

    public ArrayList<Location> getLocations() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<Location> locations = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s ORDER BY %s", LOCATION_TABLE, LOCATION_COL_ORDERCODE);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    locations.add(getLocationFromCursor(c));
                }
            }

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return locations;
    }

    private static Location getLocationFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        Location location = new Location();
        location.setId(c.getLong(c.getColumnIndex(LocationDBHelper.LOCATION_COL_ID)));
        location.setCode(c.getString(c.getColumnIndex(LocationDBHelper.LOCATION_COL_CODE)));
        location.setOrderCode(c.getString(c.getColumnIndex(LocationDBHelper.LOCATION_COL_ORDERCODE)));
        location.setIsMultiCapacity(c.getInt(c.getColumnIndex(LocationDBHelper.LOCATION_COL_ISMULTICAPACITY)) > 0);
        return location;
    }

    public boolean removeLocation(long id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(LOCATION_TABLE, String.format("%s = %s", LOCATION_COL_ID, Long.toString(id)), null) > 0;
    }

    public void addLocation(Location location) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LOCATION_COL_CODE, location.getCode());
        cv.put(LOCATION_COL_ORDERCODE, location.getOrderCode());
        cv.put(LOCATION_COL_ISMULTICAPACITY, location.isMultiCapacity());

        db.insert(LOCATION_TABLE, null, cv);
    }
}
