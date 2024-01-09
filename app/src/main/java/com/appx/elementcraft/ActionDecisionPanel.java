package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ActionDecisionPanel extends LinearLayout{

    private FlexButton cancelButton;
    private FlexButton confirmButton;
    private ActionListener actionListener;

    public interface ActionListener
    {
        void onConfirmClick();
        void onCancelClick();
    }

    public ActionDecisionPanel(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ActionDecisionPanel(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ActionDecisionPanel);
        String confirmText = a.getString(R.styleable.ActionDecisionPanel_confirm_text);
        String cancelText = a.getString(R.styleable.ActionDecisionPanel_cancel_text);

        if(confirmText !=null)
            setConfirmText(confirmText);
        if(cancelText !=null)
            setCancelText(cancelText);
        a.recycle();

        confirmButton.setOnClickListener(v -> actionListener.onConfirmClick());
        cancelButton.setOnClickListener(v-> actionListener.onCancelClick());
    }

    public void setActionListener(ActionListener actionListener)
    {
        this.actionListener=actionListener;
    }

    private void init(Context context)
    {
        inflate(context,R.layout.action_decision_panel,this);
        cancelButton = findViewById(R.id.cancelButton);
        confirmButton = findViewById(R.id.confirmButton);
    }

    public void setConfirmText(CharSequence text)
    {
        confirmButton.setText(text);
    }

    public void setCancelText(CharSequence text)
    {
        cancelButton.setText(text);
    }
}

