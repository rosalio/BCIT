package com.comp3617.assignment3.model;


import java.io.Serializable;

public class Setting implements Serializable {

    public static final String SETTING_DATA = "SETTING_DATA";

    private long id;
    private boolean enableReminder;
    private boolean enableEmail;

    public Setting() {
    }

    public Setting(long id, boolean enableReminder, boolean enableEmail) {
        this.id = id;
        this.enableReminder = enableReminder;
        this.enableEmail = enableEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnableReminder() {
        return enableReminder;
    }

    public void setEnableReminder(boolean enableReminder) {
        this.enableReminder = enableReminder;
    }

    public boolean isEnableEmail() {
        return enableEmail;
    }

    public void setEnableEmail(boolean enableEmail) {
        this.enableEmail = enableEmail;
    }
}
