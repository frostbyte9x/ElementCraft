package com.appx.elementcraft;

import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class Switch extends LinearLayout
{
    public Switch(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public Switch(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.switch_toggle,this);
    }

}
