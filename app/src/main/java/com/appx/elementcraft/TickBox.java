package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TickBox extends LinearLayout
{
    private TextView textView;
    private CheckBox checkBox;
    public TickBox(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public TickBox(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);

        checkBox.setChecked(false);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.check_box);
        String label = array.getString(R.styleable.check_box_text);
        setLabel(label);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.tick_box,this);
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.checkBox);
    }


    public void setLabel(String charSequence)
    {
        textView.setText(charSequence);
    }

    public boolean getCheckBoxValue()
    {
        return checkBox.isChecked();
    }

    public void setCheckBoxToggle()
    {
        checkBox.setChecked(!getCheckBoxValue());
    }
}
