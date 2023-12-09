package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlexButton extends LinearLayout
{
    private TextView textView;
    public FlexButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.FlexButton);
        String style = array.getString(R.styleable.FlexButton_style);
        String text = array.getString(R.styleable.FlexButton_text);
        textView = findViewById(R.id.textView);
        setButtonStyle(context,style);

        setText(text != null ? text : "Done");
        array.recycle();
    }
    public void setText(CharSequence text)
    {
        textView.setText(text);
    }
    public void setVisibility(int visId)
    {
        super.setVisibility(visId);
    }
    public void setButtonStyle(Context context,String style)
    {
        LayoutInflater.from(context).inflate(resolveStyleLayoutResource(style), this, true);
    }
    private int resolveStyleLayoutResource(String style)
    {
        switch (style)
        {
            case "cancel_button":return R.layout.button_cancel;
            case "back_button":return R.layout.button_back;
            default: return R.layout.button_ok;
        }

    }
}