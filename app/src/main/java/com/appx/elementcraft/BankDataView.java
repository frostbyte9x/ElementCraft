package com.appx.elementcraft;

import android.content.res.TypedArray;
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
            case "rose": return R.drawable.rose_quartz_elegance;
            case "golden": return R.drawable.golden_radiance;
            case "lavender": return R.drawable.lavender_bliss;
            default: return R.drawable.azure_serenity;
        }
    }
}
