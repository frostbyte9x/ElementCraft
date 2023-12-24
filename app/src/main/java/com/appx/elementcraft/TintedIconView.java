package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;

public class TintedIconView extends FrameLayout
{
    private ImageView icon;
    private ImageView iconBackground;
    public TintedIconView(@NonNull Context context)
    {
        super(context);
    }

    public TintedIconView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.tinted_icon_view);
        int resIcon = array.getInt(R.styleable.tinted_icon_view_res_icon,0);
        int resBackground=array.getInt(R.styleable.tinted_icon_view_res_bg,0);
        array.recycle();
    }

    private void init(Context context)
    {
        inflate(context,R.layout.tinted_icon_view,this);
        icon = findViewById(R.id.imageView);
        iconBackground = findViewById(R.id.imageViewBackground);
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

    public void setIcon(int resId)
    {
        icon.setImageResource(resId);
    }

    public void setIconBackground(int resId)
    {
        icon.setImageResource(resId);
    }
}
