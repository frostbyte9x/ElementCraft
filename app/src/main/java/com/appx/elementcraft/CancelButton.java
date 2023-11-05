package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class CancelButton extends CardView {

    private TextView textView;

    public CancelButton(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public CancelButton(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.cancel_button);
        String text = a.getString(R.styleable.cancel_button_text);

        if(text != null)
            textView.setText(text);
        else
            textView.setText(R.string.cancel);
        a.recycle();

    }

    private void init(Context context)
    {
        inflate(context,R.layout.cancel_button,this);
        textView = findViewById(R.id.textView);
    }

    public void setText(CharSequence text)
    {
        textView.setText(text);
    }
}
