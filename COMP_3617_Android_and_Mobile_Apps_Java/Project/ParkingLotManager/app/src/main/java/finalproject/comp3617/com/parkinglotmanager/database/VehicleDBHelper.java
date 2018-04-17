package finalproject.comp3617.com.parkinglotmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

import finalproject.comp3617.com.parkinglotmanager.model.Vehicle;

public class VehicleDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "parking_lot_manager.db";
    private static final int DB_VERSION = 1;

    private static final String VEHICLE_TABLE = "Vehicle";

    private static final String VEHICLE_COL_ID = BaseColumns._ID;
    private static final String VEHICLE_COL_LOCATIONID = "locationId";
    private static final String VEHICLE_COL_TYPE = "type";
    private static final String VEHICLE_COL_MAKE = "make";
    private static final String VEHICLE_COL_MODEL = "model";
    private static final String VEHICLE_COL_LICENSEPLATE = "licensePlate";
    private static final String VEHICLE_COL_SCANNABLEID = "scannableId";
    private static final String VEHICLE_COL_ARRIVALTIME = "arrivalTime";
    private static final String VEHICLE_COL_DEPARTURETIME = "departuretTime";

    private static final String VEHICLE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS Vehicle ( " +
            VEHICLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            VEHICLE_COL_LOCATIONID + " TEXT DEFAULT NULL, " +
            VEHICLE_COL_TYPE + " TEXT NOT NULL, " +
            VEHICLE_COL_MAKE + " TEXT NOT NULL, " +
            VEHICLE_COL_MODEL + " TEXT NOT NULL, " +
            VEHICLE_COL_LICENSEPLATE + " TEXT NOT NULL, " +
            VEHICLE_COL_SCANNABLEID + " TEXT DEFAULT NULL, " +
            VEHICLE_COL_ARRIVALTIME + " TIMESTAMP DEFAULT NULL, " +
            VEHICLE_COL_DEPARTURETIME + " TIMESTAMP DEFAULT NULL);";

    private static VehicleDBHelper INSTANCE;

    public static VehicleDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new VehicleDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private VehicleDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(VEHICLE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + VEHICLE_TABLE);
        onCreate(db);
    }

    public ArrayList<Vehicle> getVehiclesInFacility() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s IS NOT NULL", VEHICLE_TABLE, VEHICLE_COL_LOCATIONID);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    vehicles.add(getVehicleFromCursor(c));
                }
            }

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return vehicles;
    }

    private static Vehicle getVehicleFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setId(c.getLong(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_ID)));
        vehicle.setLocationId(c.getLong(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_LOCATIONID)));
        vehicle.setType(c.getString(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_TYPE)));
        vehicle.setMake(c.getString(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_MAKE)));
        vehicle.setModel(c.getString(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_MODEL)));
        vehicle.setLicensePlate(c.getString(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_LICENSEPLATE)));
        vehicle.setScannableId(c.getString(c.getColumnIndex(VehicleDBHelper.VEHICLE_COL_SCANNABLEID)));
        return vehicle;
    }


    public void checkInVehicle(Vehicle vehicle) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(VEHICLE_COL_LOCATIONID, vehicle.getLocationId());
        cv.put(VEHICLE_COL_TYPE, vehicle.getType());
        cv.put(VEHICLE_COL_MAKE, vehicle.getMake());
        cv.put(VEHICLE_COL_MODEL, vehicle.getModel());
        cv.put(VEHICLE_COL_LICENSEPLATE, vehicle.getLicensePlate());
        cv.put(VEHICLE_COL_SCANNABLEID, vehicle.getScannableId());
        db.insert(VEHICLE_TABLE, null, cv);
    }

    public void checkOutVehicle(Vehicle vehicle) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(VEHICLE_COL_LOCATIONID, vehicle.getLocationId());
        cv.put(VEHICLE_COL_SCANNABLEID, vehicle.getScannableId());
        db.update(VEHICLE_TABLE, cv, VEHICLE_COL_ID + "=" + vehicle.getId(), null);
    }
}
