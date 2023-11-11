package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TickBox extends LinearLayout
{
    public TickBox(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public TickBox(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.tick_box,this);

    }
}
