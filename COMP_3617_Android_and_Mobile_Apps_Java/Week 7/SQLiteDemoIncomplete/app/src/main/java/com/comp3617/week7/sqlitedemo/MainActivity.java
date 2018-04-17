package com.comp3617.week7.sqlitedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.comp3617.week7.sqlitedemo.db.Note;
import com.comp3617.week7.sqlitedemo.db.NotesDBHelper;

public class MainActivity extends AppCompatActivity {

    private ListView lvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNotes = (ListView)findViewById(R.id.lvNotes);
        NotesDBHelper dbHelper = NotesDBHelper.getInstance(this);
        ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, dbHelper.getNotes());
        lvNotes.setAdapter(adapter);

    }


}
