package com.comp3617.assignment3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.comp3617.assignment3.model.Task;
import com.comp3617.assignment3.util.DateHelper;

import java.util.ArrayList;

public class TaskDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "task_manager.db";
    private static final int DB_VERSION = 1;

    private static final String TASK_TABLE = "Task";

    private static final String TASK_COL_ID = BaseColumns._ID;
    private static final String TASK_COL_TITLE = "title";
    private static final String TASK_COL_DESCRIPTION = "description";
    private static final String TASK_COL_DUEDATE = "dueDate";
    private static final String TASK_COL_STATUS = "status";
    private static final String TASK_COL_CATEGORY = "category";
    private static final String TASK_COL_PRIORITY = "priority";

    private static final String TASK_TABLE_CREATE =  "CREATE TABLE IF NOT EXISTS Task ( " +
            TASK_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TASK_COL_TITLE + " TEXT NOT NULL, " +
            TASK_COL_DESCRIPTION + " TEXT NOT NULL, " +
            TASK_COL_DUEDATE + " TEXT NOT NULL, " +
            TASK_COL_STATUS + " TEXT NOT NULL, " +
            TASK_COL_CATEGORY + " TEXT NOT NULL, " +
            TASK_COL_PRIORITY + " TEXT NOT NULL);";

    private static TaskDBHelper INSTANCE;

    public static TaskDBHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TaskDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private TaskDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(TASK_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE);
        onCreate(db);
    }

    public ArrayList<Task> getTasks() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s", TASK_TABLE);
            c = db.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0) {
                while (c.moveToNext()) {
                    tasks.add(getTaskFromCursor(c));
                }
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return tasks;
    }

    private static Task getTaskFromCursor(Cursor c) {
        if ((c == null) || (c.getCount() == 0)) {
            return null;
        }

        Task task = new Task();
        task.setId(c.getLong(c.getColumnIndex(TASK_COL_ID)));
        task.setTitle(c.getString(c.getColumnIndex(TASK_COL_TITLE)));
        task.setDescription(c.getString(c.getColumnIndex(TASK_COL_DESCRIPTION)));
        task.setDueDate(DateHelper.convertToCalendar(c.getString(c.getColumnIndex(TASK_COL_DUEDATE))));
        task.setStatus(Task.parseStringToStatus(c.getString(c.getColumnIndex(TASK_COL_STATUS))));
        task.setCategory(Task.parseStringToCategory(c.getString(c.getColumnIndex(TASK_COL_CATEGORY))));
        task.setPriority(Task.parseStringToPriority(c.getString(c.getColumnIndex(TASK_COL_PRIORITY))));

        return task;
    }

    public boolean removeTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TASK_TABLE, String.format("%s = %d", TASK_COL_ID, task.getId()), null) > 0;
    }

    public void addtask(Task task) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TASK_COL_TITLE, task.getTitle());
        cv.put(TASK_COL_DESCRIPTION, task.getDescription());
        cv.put(TASK_COL_DUEDATE, DateHelper.getDateString(task.getDueDate()));
        cv.put(TASK_COL_STATUS, task.getStatus().name());
        cv.put(TASK_COL_CATEGORY, task.getCategory().name());
        cv.put(TASK_COL_PRIORITY, task.getPriority().name());

        db.insert(TASK_TABLE, null, cv);
    }

    public void updateTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TASK_COL_TITLE, task.getTitle());
        cv.put(TASK_COL_DESCRIPTION, task.getDescription());
        cv.put(TASK_COL_DUEDATE, DateHelper.getDateString(task.getDueDate()));
        cv.put(TASK_COL_STATUS, task.getStatus().name());
        cv.put(TASK_COL_CATEGORY, task.getCategory().name());
        cv.put(TASK_COL_PRIORITY, task.getPriority().name());

        db.update(TASK_TABLE, cv, TASK_COL_ID + "=" + task.getId(), null);
    }
}
