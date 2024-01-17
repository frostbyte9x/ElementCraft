package com.appx.elementcraft;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public class ConfirmationDialog extends AlertDialog
{
    private ActionDecisionPanel adp;
    private TextView heading;
    private TextView msg;
    private ActionListener actionListener;

    public interface ActionListener
    {
        void onConfirmClick();
        void onCancelClick();
    }

    public void setActionListener(ActionListener actionListener)
    {
        this.actionListener = actionListener;
    }

    public ConfirmationDialog(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ConfirmationDialog(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.confirmation_dialog);
        String headingText = array.getString(R.styleable.confirmation_dialog_heading_text);
        String messageText = array.getString(R.styleable.confirmation_dialog_message_text);

        if(headingText != null)
            setHeading(headingText);
        if(messageText != null)
            setMessage(messageText);
    }

    private void init(Context context)
    {
        View customView = LayoutInflater.from(context).inflate(R.layout.confirmation_dialog, null);
        Objects.requireNonNull(getWindow()).setBackgroundDrawableResource(R.drawable.dialog_background);
        setView(customView);
        adp = customView.findViewById(R.id.adp);
        heading = customView.findViewById(R.id.heading);
        msg = customView.findViewById(R.id.message);

        adp.setActionListener(new ActionDecisionPanel.ActionListener() {
            @Override
            public void onConfirmClick() {
                if(actionListener != null)
                    actionListener.onConfirmClick();
            }

            @Override
            public void onCancelClick() {
                if(actionListener != null)
                    actionListener.onCancelClick();
            }
        });
    }

    public void setHeading(String charSequence)
    {
        heading.setText(charSequence);
    }

    public void setMessage(String charSequence)
    {
        msg.setText(charSequence);
    }

    public void showDialog(String heading, String message)
    {
        setHeading(heading!=null?heading:"Alert!");
        setMessage(message);
        show();
    }
    public void showDialog(String message)
    {
        setHeading("Alert!");
        setMessage(message);
        show();
    }
}