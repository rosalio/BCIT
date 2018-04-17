package com.comp3617.assignment3.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.comp3617.assignment3.Callback;
import com.comp3617.assignment3.R;

public class ConfirmationDialog extends Dialog {

    private Button yesButton;
    private Button noButton;
    private int backgroundResource;
    private int buttonTextColor;
    private int headerResource;

    private Callback<Void> onClickYesCallback;

    public ConfirmationDialog(Context context, int backgroundResource, int buttonTextColor, int headerResource) {
        super(context);
        this.backgroundResource = backgroundResource;
        this.buttonTextColor = buttonTextColor;
        this.headerResource = headerResource;
    }

    public void setOnClickYesCallback(Callback<Void> callback) {
        this.onClickYesCallback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirmation);

        RelativeLayout backgroundRelativeLayout = (RelativeLayout) findViewById(R.id.confirmationDialogBackgroundLayout);
        backgroundRelativeLayout.setBackgroundResource(backgroundResource);

        TextView headerTextView = (TextView) findViewById(R.id.confirmationDialogHeaderTextView);
        headerTextView.setText(headerResource);

        yesButton = (Button) findViewById(R.id.confirmationDialogYesButton);
        yesButton.setTextColor(buttonTextColor);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickYesCallback != null) {
                    onClickYesCallback.onSuccess(null);
                }
            }
        });

        noButton = (Button) findViewById(R.id.confirmationDialogNoButton);
        noButton.setTextColor(buttonTextColor);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
