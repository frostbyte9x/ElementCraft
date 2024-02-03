package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.ButtonV2Binding;

public class FlexButtonV2 extends LinearLayout
{
    private TextView textView;
    private ImageView imageView;
    private LinearLayout imageLayout;

    public FlexButtonV2(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public FlexButtonV2(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FlexButtonV2);
        String text = array.getString(R.styleable.FlexButtonV2_text);
        int resId = array.getResourceId(R.styleable.FlexButtonV2_button_image,0);

        setText(text != null ? text : "Done");
        setImage(resId);

        array.recycle();
    }

    private void init(Context context)
    {
        ButtonV2Binding binding = ButtonV2Binding.inflate(LayoutInflater.from(context),this,true);
        textView = binding.textView;
        imageView = binding.imageView;
        imageLayout = binding.imageLayout;
    }

    public void setText(CharSequence text)
    {
        textView.setText(text);
    }

    public void setImage(int resId)
    {
        if(resId != 0)
            imageView.setImageResource(resId);
        else
            imageLayout.setVisibility(GONE);
    }
}