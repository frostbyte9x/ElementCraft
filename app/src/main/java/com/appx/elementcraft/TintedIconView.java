package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.appx.elementcraft.databinding.TintedIconViewBinding;
import android.content.Context;

public class TintedIconView extends FrameLayout
{
    private TintedIconViewBinding binding;
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
        binding = TintedIconViewBinding.inflate(LayoutInflater.from(context),this,true);
        icon = binding.imageView;
        iconBackground = binding.imageViewBackground;
    }

    private int[] resolveStyledResource(String theme)
    {
        if(theme.equalsIgnoreCase("rose"))
            return new int[]{R.color.rose,R.drawable.bg_rose};
        else if(theme.equalsIgnoreCase("lavender"))
            return new int[]{R.color.lavender,R.drawable.bg_lavender};
        else if(theme.equalsIgnoreCase("golden"))
            return new int[]{R.color.golden,R.drawable.bg_golden};
        else return new int[]{R.color.azure,R.drawable.bg_azure};
    }

//    public void setIcon(int resId)
//    {
//        icon.setImageResource(resId);
//    }

    public void setIcon(int resId, String theme)
    {
        int[] res = resolveStyledResource(theme);
        iconBackground.setImageResource(res[1]);
        icon.setImageResource(resId);
        icon.setColorFilter(ContextCompat.getColor(context, res[0]), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

//    public void setIconBackground(int resId)
//    {
//        icon.setImageResource(resId);
//    }
}
