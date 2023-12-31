package com.appx.elementcraft;

import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.content.Context;

public class BankDataView extends LinearLayout
{
    public BankDataView(Context context, AttributeSet attrs)
    {
        super(context,attrs);

//        TypedArray array = context.obtainStyledAttributes(attrs);
//        array.recycle();
    }

    private int resolveStyledDrawableResource(String style)
    {
        switch(style)
        {
            case "rose": return R.drawable.bg_rose;
            case "golden": return R.drawable.bg_golden;
            case "lavender": return R.drawable.bg_lavender;
            default: return R.drawable.bg_azure;
        }
    }
}
