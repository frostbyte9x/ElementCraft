package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ConfirmationDialog extends LinearLayout
{
    public ConfirmationDialog(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ConfirmationDialog(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.confirmation_dialog,this);
    }
}
