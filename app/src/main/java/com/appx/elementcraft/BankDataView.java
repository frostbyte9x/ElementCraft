package com.appx.elementcraft;

import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BankDataView extends LinearLayout
{
    public BankDataView(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public BankDataView(@NonNull Context context,@Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(@NonNull Context context)
    {
        inflate(context,R.layout.bank_data_view,this);
    }
}
