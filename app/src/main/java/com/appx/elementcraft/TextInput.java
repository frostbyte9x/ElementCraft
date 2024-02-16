package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.text.InputFilter;
import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.TextInputBinding;

public class TextInput extends LinearLayout
{
    private EditText textInput;
    private TextView heading;

    public TextInput(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public TextInput(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TextInput);
        String text = array.getString(R.styleable.TextInput_text);
        String hintText = array.getString(R.styleable.TextInput_hint);
        String headingText = array.getString(R.styleable.TextInput_heading_text);
        configure(headingText,text,hintText);
        array.recycle();
    }

    private void init(Context context)
    {
        TextInputBinding binding = TextInputBinding.inflate(LayoutInflater.from(context),this,true);
        textInput = binding.editText;
        heading = binding.textView;
    }

    public void setHeading(String text)
    {
        heading.setText(text);
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
        return textInput.getText().toString().trim();
    }

    public void configure(String heading,String text,String hint)
    {
        if (text != null)
            setText(text);
        if (hint != null)
            setHint(hint);
        if (heading != null)
            setHeading(heading);
    }

    public void setMaxTextLimit(int textLimit)
    {
        textInput.setFilters(new InputFilter[] { new InputFilter.LengthFilter(textLimit) });
    }
}