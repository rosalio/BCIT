package com.comp3617.assignment3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comp3617.assignment3.R;
import com.comp3617.assignment3.database.TaskDBHelper;
import com.comp3617.assignment3.model.Task;
import com.comp3617.assignment3.ui.adapter.TaskListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DisplayTasksActivity extends AppCompatActivity {

    @Bind(R.id.taskListView)
    ListView taskListView;

    private TaskListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tasks);
        ButterKnife.bind(this);
    }

    private void initializeViews() {
        List<Task> tasks = TaskDBHelper.getInstance(this).getTasks();
        adapter = new TaskListAdapter(this, tasks);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), EditTaskActivity.class);
                intent.putExtra(Task.TASK_DATA, task);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_create) {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_setting) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }

        return true;
    }
}
