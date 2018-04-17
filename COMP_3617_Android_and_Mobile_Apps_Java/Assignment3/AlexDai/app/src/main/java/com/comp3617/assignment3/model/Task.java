package com.comp3617.assignment3.model;

import java.io.Serializable;
import java.util.Calendar;

public class Task implements Serializable {

    public static final String TASK_DATA = "TASK_DATA";

    public enum Status {
        PENDING,
        COMPLETED
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Category {
        PERSONAL,
        WORK,
        HOME
    }

    private long id;
    private String title;
    private String description;
    private Calendar dueDate;
    private Status status;
    private Category category;
    private Priority priority;

    public Task() {
    }

    public Task(long id, String title, String description, Calendar dueDate, Status status, Category category, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.category = category;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public static Status parseStringToStatus(String str) {
        if (str == null) {
            return null;
        }
        switch (str.toUpperCase()) {
            case "COMPLETED" :
                return Status.COMPLETED;
            case "PENDING" :
                return Status.PENDING;
            default:
                return null;
        }
    }

    public static Category parseStringToCategory(String str) {
        if (str == null) {
            return null;
        }
        switch (str.toUpperCase()) {
            case "PERSONAL" :
                return Category.PERSONAL;
            case "WORK" :
                return Category.WORK;
            case "HOME" :
                return Category.HOME;
            default:
                return null;
        }
    }

    public static Priority parseStringToPriority(String str) {
        if (str == null) {
            return null;
        }
        switch (str.toUpperCase()) {
            case "LOW" :
                return Priority.LOW;
            case "MEDIUM" :
                return Priority.MEDIUM;
            case "HIGH" :
                return Priority.HIGH;
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null)
            return false;
        if (dueDate != null ? !dueDate.equals(task.dueDate) : task.dueDate != null) return false;
        if (status != task.status) return false;
        if (category != task.category) return false;
        return priority == task.priority;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
