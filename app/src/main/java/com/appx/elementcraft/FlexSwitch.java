package com.appx.elementcraft;

import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class FlexSwitch extends LinearLayout
{
    Switch s;
    public FlexSwitch(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public FlexSwitch(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.switch_toggle,this);
    }

}
