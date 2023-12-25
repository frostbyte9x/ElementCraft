package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TintedTextView extends LinearLayout
{
    private TextView textView;

    public TintedTextView(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public TintedTextView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TintedTextView);
        String style = array.getString(R.styleable.TintedTextView_style);
        String text = array.getString(R.styleable.TintedTextView_text);
        array.recycle();
    }

    private void init(Context context)
    {
        inflate(context,R.layout.tinted_text_view,this);
        textView = findViewById(R.id.textView);
    }

    public void setText(String text)
    {
        textView.setText(text);
    }
}
