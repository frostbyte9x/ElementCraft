package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SectionDivider extends LinearLayout {
    private TextView textView;

    public SectionDivider(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public SectionDivider(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.section_divider);
        String text = a.getString(R.styleable.section_divider_text);
        if(text != null)
            setText(text);
        a.recycle();

    }

    private void init(Context context)
    {
        inflate(context, R.layout.section_divider,this);
        textView = findViewById(R.id.textView);
    }

    public void setText(CharSequence text)
    {
        textView.setText(text);
    }


}
