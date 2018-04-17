package finalproject.comp3617.com.parkinglotmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

import finalproject.comp3617.com.parkinglotmanager.model.Device;

public class DeviceDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "parking_lot_manager.db";
    private static final int DB_VERSION = 1;

    private static final String DEVICE_TABLE = "Device";

    private static final String DEVICE_COL_ID = BaseColumns._ID;
    private static final String DEVICE_COL_IMEI = "imei";

    private static final String DEVICE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS Device ( " +
            DEVICE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DEVICE_COL_IMEI + " TEXT NOT NULL);";

    private static DeviceDBHelper INSTANCE;

    public static DeviceDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DeviceDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private DeviceDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(DEVICE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DEVICE_TABLE);
        onCreate(db);
    }

    public boolean removeDevice(String deviceIMEI) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(DEVICE_TABLE, String.format("%s = %s", DEVICE_COL_IMEI, deviceIMEI), null) > 0;
    }

    public void addDevice(String deviceIMEI) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DEVICE_COL_IMEI, deviceIMEI);
        db.insert(DEVICE_TABLE, null, cv);
    }

    public ArrayList<Device> getDevices() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<Device> devices = new ArrayList<>();

        try {
            String query = String.format("SELECT _id, %s FROM %s", DeviceDBHelper.DEVICE_COL_IMEI, DEVICE_TABLE);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    devices.add(getDeviceFromCursor(c));
                }
            }

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return devices;
    }

    private static Device getDeviceFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        Device device = new Device();
        device.setId(c.getLong(c.getColumnIndex(DeviceDBHelper.DEVICE_COL_ID)));
        device.setImei(c.getString(c.getColumnIndex(DeviceDBHelper.DEVICE_COL_IMEI)));
        return device;
    }

    public boolean isDeviceRegistered(String imei) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        Device device = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE %s=\"%s\"", DEVICE_TABLE, DEVICE_COL_IMEI, imei);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                c.moveToNext();
                device = getDeviceFromCursor(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }

        if (device == null) {
            return false;
        }
        return true;
    }

}
