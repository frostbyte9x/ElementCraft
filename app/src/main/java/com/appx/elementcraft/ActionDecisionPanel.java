package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ActionDecisionPanel extends LinearLayout{

    private Button cancelButton;
    private Button button;

    public ActionDecisionPanel(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ActionDecisionPanel(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.action_decision_panel);
        String confirmText = a.getString(R.styleable.action_decision_panel_confirm_text);
        String cancelText = a.getString(R.styleable.action_decision_panel_cancel_text);

        if(confirmText !=null)
            setConfirmText(confirmText);
        if(cancelText !=null)
            setCancelText(cancelText);
        a.recycle();
    }

    private void init(Context context)
    {
        inflate(context,R.layout.action_decision_panel,this);
        cancelButton = findViewById(R.id.cancelButton);
        button = findViewById(R.id.confirmButton);
    }

    public void setConfirmText(CharSequence text)
    {
        button.setText(text);
    }

    public void setCancelText(CharSequence text)
    {
        cancelButton.setText(text);
    }


}
