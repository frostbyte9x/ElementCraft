package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Button extends LinearLayout
{
    private TextView textView;
    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.button);
        String style = array.getString(R.styleable.button_style);
        String text = array.getString(R.styleable.button_text);
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
    private void setButtonStyle(Context context,String style)
    {
        style = resolveStyleLayoutResource(style);
        int resId = getResources().getIdentifier(style,"layout",context.getPackageName());
        LayoutInflater.from(context).inflate(resId, this, true);
        textView = findViewById(R.id.textView);
    }

    private String resolveStyleLayoutResource(String style)
    {
        switch (style)
        {
            case "cancel_button": return "@layout/cancel_button";
            default: return "@layout/button";
        }
    }
}
