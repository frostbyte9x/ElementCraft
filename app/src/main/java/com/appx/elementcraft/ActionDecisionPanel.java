package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ActionDecisionPanel extends LinearLayout{

    private FlexButton cancelFlexButton;
    private FlexButton flexButton;

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
    }

    private void init(Context context)
    {
        inflate(context,R.layout.action_decision_panel,this);
        cancelFlexButton = findViewById(R.id.cancelButton);
        flexButton = findViewById(R.id.confirmButton);
    }

    public void setConfirmText(CharSequence text)
    {
        flexButton.setText(text);
    }

    public void setCancelText(CharSequence text)
    {
        cancelFlexButton.setText(text);
    }
}