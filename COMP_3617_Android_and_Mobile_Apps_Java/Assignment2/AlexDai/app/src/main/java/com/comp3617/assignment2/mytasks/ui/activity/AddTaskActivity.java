package com.comp3617.assignment2.mytasks.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.comp3617.assignment2.mytasks.ui.dialog.PickerDialog;
import com.comp3617.assignment2.mytasks.R;
import com.comp3617.assignment2.mytasks.model.Task;
import com.comp3617.assignment2.mytasks.model.TaskList;
import com.comp3617.assignment2.mytasks.util.DateHelper;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddTaskActivity extends FragmentActivity implements PickerDialog.TheListener {

    @Bind(R.id.titleEditText)
    EditText titleEditText;

    @Bind(R.id.descriptionEditText)
    EditText descriptionEditText;

    @Bind(R.id.dueDateTextView)
    TextView dueDateTextView;

    @Bind(R.id.statusSpinner)
    Spinner statusSpinner;

    @Bind(R.id.categorySpinner)
    Spinner categorySpinner;

    @Bind(R.id.prioritySpinner)
    Spinner prioritySpinner;

    @Bind(R.id.datePickerButton)
    ImageButton datePickerButton;

    @Bind(R.id.cancelButton)
    Button cancelButton;

    @Bind(R.id.saveButton)
    Button saveButton;

    @Bind(R.id.reminderCheckBox)
    CheckBox reminderCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        initializeViews();
    }

    private void initializeViews() {
        addDatePickerButtonListener();
        addCancelButtonListener();
        addSaveButtonListener();
    }

    private void addDatePickerButtonListener() {
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickerDialog pickerDialog = new PickerDialog();
                pickerDialog.show(getFragmentManager(), "date_picker");
            }
        });
    }

    private void addCancelButtonListener() {
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addSaveButtonListener() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canTaskBeAdded()) {
                    Task newTask = new Task();
                    newTask.setTitle(titleEditText.getText().toString());
                    newTask.setDescription(descriptionEditText.getText().toString());
                    newTask.setDueDate(DateHelper.convertToCalendar(dueDateTextView.getText().toString()));
                    newTask.setStatus(Task.parseStringToStatus(statusSpinner.getSelectedItem().toString()));
                    newTask.setCategory(Task.parseStringToCategory(categorySpinner.getSelectedItem().toString()));
                    newTask.setPriority(Task.parseStringToPriority(prioritySpinner.getSelectedItem().toString()));
                    TaskList.addTask(newTask);

                    if (reminderCheckBox.isChecked()) {
                        addCalendarReminder(newTask);
                    }

                    finish();
                }
            }
        });
    }

    private void addCalendarReminder(Task task) {
        Calendar calendar = task.getDueDate();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, task.getTitle());
        intent.putExtra(CalendarContract.Events.DESCRIPTION, task.getDescription());
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendar.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);

        startActivity(intent);
    }

    @Override
    public void returnDate(String date) {
        dueDateTextView.setText(date);
    }

    private boolean canTaskBeAdded() {
        if (titleEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.warning_message_title), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (descriptionEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.warning_message_description), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (dueDateTextView.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.warning_message_due_date), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
