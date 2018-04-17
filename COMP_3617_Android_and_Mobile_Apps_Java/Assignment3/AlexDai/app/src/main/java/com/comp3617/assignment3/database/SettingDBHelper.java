package com.comp3617.assignment3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.comp3617.assignment3.model.Setting;

import java.util.ArrayList;

public class SettingDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "task_manager.db";
    private static final int DB_VERSION = 1;

    private static final String SETTING_TABLE = "Setting";

    private static final String SETTING_COL_ID = BaseColumns._ID;
    private static final String SETTING_COL_ENABLEREMINDER = "enableReminder";
    private static final String SETTING_COL_ENABLEEMAIL = "enableEmail";

    private static final String SETTING_TABLE_CREATE =  "CREATE TABLE IF NOT EXISTS Setting ( " +
            SETTING_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SETTING_COL_ENABLEREMINDER + " BIT(1) NOT NULL DEFAULT 0, " +
            SETTING_COL_ENABLEEMAIL + " BIT(1) NOT NULL DEFAULT 0);";

    private static SettingDBHelper INSTANCE;

    public static SettingDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SettingDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private SettingDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(SETTING_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SETTING_TABLE);
        onCreate(db);
    }

    public ArrayList<Setting> getSettings() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<Setting> settings = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s", SETTING_TABLE);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    settings.add(getSettingFromCursor(c));
                }
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return settings;
    }

    public Setting getSetting() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        Setting setting = new Setting();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s = %d", SETTING_TABLE, SETTING_COL_ID, 1);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                c.moveToNext();
                setting = getSettingFromCursor(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return setting;
    }

    private static Setting getSettingFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        Setting setting = new Setting();
        setting.setId(c.getLong(c.getColumnIndex(SETTING_COL_ID)));
        setting.setEnableReminder(c.getInt(c.getColumnIndex(SETTING_COL_ENABLEREMINDER)) > 0);
        setting.setEnableEmail(c.getInt(c.getColumnIndex(SETTING_COL_ENABLEEMAIL)) > 0);

        return setting;
    }

    public void addSetting(Setting setting) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SETTING_COL_ENABLEREMINDER, setting.isEnableReminder());
        cv.put(SETTING_COL_ENABLEEMAIL, setting.isEnableEmail());

        db.insert(SETTING_TABLE, null, cv);
    }

    public void updateSetting(Setting setting) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SETTING_COL_ENABLEREMINDER, setting.isEnableReminder());
        cv.put(SETTING_COL_ENABLEEMAIL, setting.isEnableEmail());

        db.update(SETTING_TABLE, cv, null, null);
    }
}
