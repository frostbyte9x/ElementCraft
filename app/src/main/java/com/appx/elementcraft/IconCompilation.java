package com.appx.elementcraft;

import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class IconCompilation extends FrameLayout
{
    private TintedIconView icon1,icon2,icon3;
    public IconCompilation(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public IconCompilation(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.icon_compilation,this);
        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
    }
    public void setIcon1(int resId, String theme)
    {
        icon1.setIcon(resId,theme);
    }
    public void setIcon2(int resId, String theme)
    {
        icon2.setIcon(resId,theme);
    }
    public void setIcon3(int resId, String theme)
    {
        icon3.setIcon(resId,theme);
    }
}
