package com.comp3617.week7.sqlitedemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by A00527696 on 3/3/2016.
 */
public class NotesDBHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "SQLiteDemo";
    private static final String DB_NAME = "my_notes.db";
    private static final int DB_VERSION = 1;

    private static final String DB_COL_TITLE = "title";
    private static final String DB_COL_BODY = "body";
    private static final String DB_COL_ID = BaseColumns._ID;

    private static final String DB_TABLE = "notes";

    private static final String DB_TABLE_CREATE = "CREATE TABLE notes ( " +
            DB_COL_ID + " integer primary key autoincrement, " +
            DB_COL_TITLE + " text not null, " +
            DB_COL_BODY + " text not null);";

    private static NotesDBHelper INSTANCE;

    public static NotesDBHelper getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = new NotesDBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

     private NotesDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOGTAG, "onCreate() method called");
        //Create the tables associated with your DB
        db.execSQL(DB_TABLE_CREATE);
        Log.d(LOGTAG, "Notes table created");

        ContentValues cv = new ContentValues();
        for(int i = 0 ; i < 10; i++) {
            cv.put(DB_COL_TITLE, String.format("Title : %d", i));
            cv.put(DB_COL_BODY, String.format("Body : %d", i));
            db.insert(DB_TABLE, null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);
    }

    ////CRUD methods

    public ArrayList<Note> getNotes() {
        Log.d(LOGTAG, "Calling getNotes()");
        SQLiteDatabase notesDB = getReadableDatabase();
        Cursor c = null;
        ArrayList<Note> notes = new ArrayList<Note>();

        try {
            //c = notesDB.query(NotesDBHelper.DB_TABLE, NotesDBHelper.DB_ALL_COLUMNS, null, null, null, null, null);
            String query = String.format("SELECT _id, %s, %S FROM %s", NotesDBHelper.DB_COL_TITLE, NotesDBHelper.DB_COL_BODY,
                    NotesDBHelper.DB_TABLE);

            c = notesDB.rawQuery(query, null);

            if ((c != null) && c.getCount() > 0 ) {
                while(c.moveToNext())
                    notes.add(getNoteFromCursor(c));
            }
        }
        finally
        {
            if (c != null)
                c.close();
        }
        return notes;
    }

    private static Note getNoteFromCursor(Cursor c){
        if ((c == null) || (c.getCount() == 0))
            return null;
        else {
            Note note = new Note();
            note.setId(c.getLong(c.getColumnIndex(NotesDBHelper.DB_COL_ID)));
            note.setTitle(c.getString(c.getColumnIndex(NotesDBHelper.DB_COL_TITLE)));
            note.setBody(c.getString(c.getColumnIndex(NotesDBHelper.DB_COL_BODY)));
            return note;
        }

    }


}
