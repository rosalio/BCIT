package com.comp3617.assignment2.mytasks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comp3617.assignment2.mytasks.R;
import com.comp3617.assignment2.mytasks.model.Task;
import com.comp3617.assignment2.mytasks.ui.adapter.TaskListAdapter;
import com.comp3617.assignment2.mytasks.model.TaskList;

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

        adapter = new TaskListAdapter(this, TaskList.getInstance().getTasks());
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), EditTaskActivity.class);
                intent.putExtra(Task.TASK_DATA, task);
                intent.putExtra("POSITION", position);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
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
        }
        return true;
    }
}
