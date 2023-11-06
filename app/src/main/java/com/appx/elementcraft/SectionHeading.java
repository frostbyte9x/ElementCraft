package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SectionHeading extends LinearLayout
{
    private TextView textView;
    public SectionHeading(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public SectionHeading(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.section_heading);
        String text = a.getString(R.styleable.section_heading_text);

        if(text != null)
            setText(text);
        a.recycle();
    }

    public void init(Context context)
    {
        inflate(context, R.layout.section_heading,this);
        textView.findViewById(R.id.textView);
    }

    public void setText(CharSequence text)
    {
        textView.setText(text);
    }
}
