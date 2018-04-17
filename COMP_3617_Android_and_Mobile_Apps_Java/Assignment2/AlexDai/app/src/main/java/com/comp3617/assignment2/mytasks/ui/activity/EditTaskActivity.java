package com.comp3617.assignment2.mytasks.ui.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.comp3617.assignment2.mytasks.R;
import com.comp3617.assignment2.mytasks.model.Task;
import com.comp3617.assignment2.mytasks.model.TaskList;
import com.comp3617.assignment2.mytasks.ui.dialog.PickerDialog;
import com.comp3617.assignment2.mytasks.util.DateHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditTaskActivity extends FragmentActivity implements PickerDialog.TheListener {

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

    @Bind(R.id.deleteButton)
    Button deleteButton;

    @Bind(R.id.saveButton)
    Button saveButton;

    @Bind(R.id.emailImageButton)
    ImageButton emailImageButton;

    private Task task;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        ButterKnife.bind(this);
        getDataFromIntent();
        initializeViews();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra(Task.TASK_DATA);
        position = intent.getIntExtra("POSITION", 0);
    }

    private void initializeViews() {
        fillTaskData();
        addDatePickerButtonListener();
        addCancelButtonListener();
        addDeleteButtonListener();
        addSaveButtonListener();
        addEmailButtonListener();
    }

    private void fillTaskData() {
        titleEditText.setText(task.getTitle());
        descriptionEditText.setText(task.getDescription());
        dueDateTextView.setText(DateHelper.getDateString(task.getDueDate()));
        statusSpinner.setSelection(getSpinnerIndex(statusSpinner, task.getStatus().name()));
        categorySpinner.setSelection(getSpinnerIndex(categorySpinner, task.getCategory().name()));
        prioritySpinner.setSelection(getSpinnerIndex(prioritySpinner, task.getPriority().name()));
    }

    private int getSpinnerIndex(Spinner spinner, String str) {
        int index = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            String spinnerStr = spinner.getItemAtPosition(i).toString().toUpperCase();
            if (spinnerStr.equals(str.toUpperCase())) {
                index = i;
                continue;
            }
        }
        return index;
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

    private void addDeleteButtonListener() {
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskList.deleteTask(task, position);
                finish();
            }
        });
    }

    private void addSaveButtonListener() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setTitle(titleEditText.getText().toString());
                task.setDescription(descriptionEditText.getText().toString());
                task.setDueDate(DateHelper.convertToCalendar(dueDateTextView.getText().toString()));
                task.setStatus(Task.parseStringToStatus(statusSpinner.getSelectedItem().toString()));
                task.setCategory(Task.parseStringToCategory(categorySpinner.getSelectedItem().toString()));
                task.setPriority(Task.parseStringToPriority(prioritySpinner.getSelectedItem().toString()));
                TaskList.updateTask(task, position);
                finish();
            }
        });
    }

    private void addEmailButtonListener() {
        emailImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"adai3@my.bcit.ca"});
                intent.putExtra(Intent.EXTRA_SUBJECT, titleEditText.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, generateEmailBody());

                try {
                    startActivity(intent.createChooser(intent, getResources().getString(R.string.send_email)));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.warning_message_no_email_application), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private String generateEmailBody() {
        String dueDate = dueDateTextView.getText().toString();
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String status = statusSpinner.getSelectedItem().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String priority = prioritySpinner.getSelectedItem().toString();

        String body = String.format("%s: %s\n" +
                                    "%s: %s\n" +
                                    "%s: %s\n" +
                                    "%s: %s\n" +
                                    "%s: %s\n" +
                                    "%s: %s\n",
                                    "Due Date", dueDate,
                                    "Title", title,
                                    "Description", description,
                                    "Status", status,
                                    "Category", category,
                                    "Priority", priority);
        return body;
    }

    @Override
    public void returnDate(String date) {
        dueDateTextView.setText(date);
    }
}
