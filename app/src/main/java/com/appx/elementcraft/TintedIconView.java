package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.content.Context;

public class TintedIconView extends FrameLayout
{
    private ImageView icon;
    private ImageView iconBackground;
    private Context context;
    public TintedIconView(@NonNull Context context)
    {
        super(context);
        this.context =context;
    }

    public TintedIconView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        this.context =context;
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TintedIconView);
        int resIcon = array.getInt(R.styleable.TintedIconView_res_id,0);
        String theme = array.getString(R.styleable.TintedIconView_style);

        if(theme!=null)
            setIcon(resIcon,theme);
        array.recycle();
    }

    private void init(Context context)
    {
        inflate(context,R.layout.tinted_icon_view,this);
        icon = findViewById(R.id.imageView);
        iconBackground = findViewById(R.id.imageViewBackground);
    }

    private int resolveStyledDrawableResource(String theme)
    {
        switch(theme)
        {
            case "rose": return R.drawable.bg_rose;
            case "golden": return R.drawable.bg_golden;
            case "lavender": return R.drawable.bg_lavender;
            default: return R.drawable.bg_azure;
        }
    }

    private int resolveStyledTextColor(String theme)
    {
        switch(theme)
        {
            case "rose":return R.color.rose;
            case "azure": return R.color.azure;
            case "golden":return R.color.golden;
            default: return R.color.lavender;
        }
    }

    public void setIcon(int resId)
    {
        icon.setImageResource(resId);
    }

    public void setIcon(int resId, String theme)
    {
        int iconColor = resolveStyledTextColor(theme);
        int background = resolveStyledDrawableResource(theme);
        iconBackground.setImageResource(background);
        icon.setImageResource(resId);
        icon.setColorFilter(ContextCompat.getColor(context, iconColor), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public void setIconBackground(int resId)
    {
        icon.setImageResource(resId);
    }
}
