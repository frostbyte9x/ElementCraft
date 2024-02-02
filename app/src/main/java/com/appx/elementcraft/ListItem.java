package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.ListItemBinding;

public class ListItem extends LinearLayout
{
    private TextView heading;
    private TextView subHeading;
    private FlexButton flexButton;
    private LinearLayout buttonLayout;
    private ActionListener actionListener;

    public interface ActionListener
    {
        void onClick();
    }

    public void setActionListener(ActionListener actionListener)
    {
        this.actionListener = actionListener;
    }

    public ListItem(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ListItem(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ListItem);
        String headingText = array.getString(R.styleable.ListItem_heading_text);
        String subHeadingText= array.getString(R.styleable.ListItem_subheading_text);
        String buttonText = array.getString(R.styleable.ListItem_button_text);

        if(headingText !=null && subHeadingText !=null && buttonText !=null)
            configure(headingText,subHeadingText,buttonText);
        if(headingText !=null && subHeadingText !=null && buttonText ==null)
            configure(headingText,subHeadingText);

        array.recycle();
    }

    private void init(Context context)
    {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(context),this,true);
        heading = binding.heading;
        subHeading = binding.subHeading;
        flexButton = binding.flexButton;
        buttonLayout = binding.buttonLayout;
    }

    public void configure(String headingText,String subHeadingText)
    {
        heading.setText(headingText);
        subHeading.setText(subHeadingText);
        buttonLayout.setVisibility(GONE);
    }

    public void configure(String headingText, String subHeadingText, String buttonText)
    {
        heading.setText(headingText);
        subHeading.setText(subHeadingText);
        flexButton.setText(buttonText);
        flexButton.setOnClickListener(v -> actionListener.onClick());
    }
}