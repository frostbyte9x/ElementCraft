package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EditText extends LinearLayout
{
    private EditText editText;

    public EditText(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public EditText(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.edittext);
        String text = a.getString(R.styleable.edittext_text);
        String hint = a.getString(R.styleable.edittext_hint);

        if(text != null)
            setText(text);

        if(hint != null)
            setHint(hint);
    }

    public void init(Context context)
    {
        inflate(context, R.layout.edit_text,this);
        editText = findViewById(R.id.editText);
    }

    public void setText(CharSequence text)
    {
        editText.setText(text);
    }

    public void setHint(CharSequence text)
    {
        editText.setHint(text);
    }

    public String getText()
    {
        return editText.getText();
    }
}
