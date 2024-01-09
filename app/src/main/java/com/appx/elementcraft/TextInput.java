package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextInput extends LinearLayout
{
    private EditText textInput;

    public TextInput(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public TextInput(@NonNull Context context, @Nullable AttributeSet attrs)
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
        a.recycle();
    }

    private void init(Context context)
    {
        inflate(context, R.layout.text_input,this);
        textInput = findViewById(R.id.editText);
    }
    public void setText(CharSequence text)
    {
        textInput.setText(text);
    }

    public void setHint(CharSequence text)
    {
        textInput.setHint(text);
    }

    public String getText()
    {
        return textInput.getText().toString();
    }
}
