package com.comp3617.assignment2.mytasks.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comp3617.assignment2.mytasks.R;
import com.comp3617.assignment2.mytasks.model.Task;

import java.util.Calendar;
import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Task>  {

    private Context context;
    private List<Task> tasks;

    public TaskListAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.item_task_list_elem, tasks);
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = tasks.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View row = null;
        if (convertView != null) {
            row = convertView;
        } else {
            row = layoutInflater.inflate(R.layout.item_task_list_elem, parent, false);
        }

        if (position % 2 == 1) {
            row.setBackgroundColor(context.getResources().getColor(R.color.grey));
        } else {

        }

        TextView dueDateTextView = (TextView) row.findViewById(R.id.dueDateTextView);
        TextView titleTextView = (TextView) row.findViewById(R.id.titleTextView);
        TextView descriptionTextView = (TextView) row.findViewById(R.id.descriptionTextView);
        TextView categoryTextView = (TextView) row.findViewById(R.id.categoryTextView);
        ImageView statusImageView = (ImageView) row.findViewById(R.id.statusImageView);
        ImageView priorityImageView = (ImageView) row.findViewById(R.id.priorityImageView);

        Integer statusImageResource = getStatusImageResource(task);
        Integer priorityImageResource = getPriorityImageResource(task);

        Calendar dueDate = task.getDueDate();
        String dueDateString = String.format("%s/%s/%s", dueDate.get(Calendar.YEAR), dueDate.get(Calendar.MONTH) + 1, dueDate.get(Calendar.DAY_OF_MONTH));
        dueDateTextView.setText(dueDateString);
        titleTextView.setText(task.getTitle());
        descriptionTextView.setText(task.getDescription());
        categoryTextView.setText(task.getCategory().name());
        statusImageView.setImageResource(statusImageResource);
        priorityImageView.setImageResource(priorityImageResource);

        return row;
    }

    Integer getStatusImageResource(Task task) {
        if (task != null) {
            switch (task.getStatus()) {
                case COMPLETED:
                    return R.drawable.ic_status_completed;
                case PENDING:
                    return R.drawable.ic_status_pending;
                default:

            }
        }
        return R.drawable.ic_status_pending;
    }

    Integer getPriorityImageResource(Task task) {
        if (task != null) {
            switch (task.getPriority()) {
                case LOW:
                    return R.drawable.ic_priority_low;
                case MEDIUM:
                    return R.drawable.ic_priority_medium;
                case HIGH:
                    return R.drawable.ic_priority_high;
                default:
            }
        }
        return R.drawable.ic_priority_low;
    }
}
