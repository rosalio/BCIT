package com.comp3617.assignment2.mytasks.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaskList {

    private static TaskList instance = null;
    private static List<Task> tasks;

    protected TaskList() {
        initializeTasksForTest();
    }

    public static TaskList getInstance() {
        if (instance == null) {
            instance = new TaskList();
        }
        return instance;
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        if (tasks == null) {
            tasks = new ArrayList<Task>();
        }

        if (task != null) {
            tasks.add(task);
        }
    }

    public static void deleteTask(Task taskToDelete, int position) {
        if (taskToDelete == null) {
            return;
        }
        tasks.remove(position);
    }

    public static void updateTask(Task taskToUpdate, int position) {
        if (taskToUpdate == null) {
            return;
        }
        tasks.set(position, taskToUpdate);
    }

    private void initializeTasksForTest() {
        addTask(new Task("Task 1", "This is Task 1", Calendar.getInstance(), Task.Status.COMPLETED, Task.Category.PERSONAL, Task.Priority.HIGH));
        addTask(new Task("Task 2", "This is Task 2", Calendar.getInstance(), Task.Status.PENDING, Task.Category.HOME, Task.Priority.MEDIUM));
        addTask(new Task("Task 3", "This is Task 3", Calendar.getInstance(), Task.Status.PENDING, Task.Category.WORK, Task.Priority.LOW));
    }

}
