package com.comp3617.assignment3.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.comp3617.assignment3.R;
import com.comp3617.assignment3.database.SettingDBHelper;
import com.comp3617.assignment3.model.Setting;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingActivity extends FragmentActivity {

    @Bind(R.id.enableReminderCheckBox)
    CheckBox enableReminderCheckBox;
    @Bind(R.id.enableEmailCheckBox)
    CheckBox enableEmailCheckBox;
    @Bind(R.id.saveButton)
    Button saveButton;
    @Bind(R.id.cancelButton)
    Button cancelButton;

    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        List<Setting> settings = SettingDBHelper.getInstance(this).getSettings();
        if (settings.size() == 0) {
            Setting newSetting = new Setting();
            newSetting.setEnableReminder(true);
            newSetting.setEnableEmail(true);
            SettingDBHelper.getInstance(this).addSetting(newSetting);
        }

        setting = SettingDBHelper.getInstance(this).getSetting();
        enableReminderCheckBox.setChecked(setting.isEnableReminder());
        enableEmailCheckBox.setChecked(setting.isEnableEmail());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting.setEnableReminder(enableReminderCheckBox.isChecked());
                setting.setEnableEmail(enableEmailCheckBox.isChecked());

                SettingDBHelper dbHelper = SettingDBHelper.getInstance(getApplicationContext());
                dbHelper.updateSetting(setting);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
