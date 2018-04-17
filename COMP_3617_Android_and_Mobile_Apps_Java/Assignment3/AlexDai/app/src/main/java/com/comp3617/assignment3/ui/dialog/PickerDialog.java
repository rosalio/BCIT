package com.comp3617.assignment3.ui.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import com.comp3617.assignment3.util.DateHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    TheListener listener;

    public interface TheListener {
        void returnDate(String date);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        listener = (TheListener) getActivity();

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = DateHelper.getDateString(calendar);

        if (listener != null) {
            listener.returnDate(formattedDate);
        }
    }
}
