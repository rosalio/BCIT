package com.comp3617.week5.actionbardemo;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //If you need to change the title in the action bar
        ActionBar ab = getSupportActionBar();
        ab.setTitle("My App");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch(item.getItemId()) {
            case R.id.action_create:
            msg = "Button create clicked";
                break;
            case R.id.action_delete:
                msg = "Button delete clicked";
                break;
            case R.id.action_settings:
                msg = "Settings button clicked";
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        return true;
    }
}
