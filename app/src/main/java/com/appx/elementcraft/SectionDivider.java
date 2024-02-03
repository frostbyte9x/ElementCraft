package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.SectionDividerBinding;

public class SectionDivider extends LinearLayout {
    private TextView header;
    private TextView subHeader;
    private LinearLayout divider;
    private FlexButtonV2 flexButton;

    public SectionDivider(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public SectionDivider(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.SectionDivider);
        String headingText = array.getString(R.styleable.SectionDivider_heading_text);
        String subHeadingText = array.getString(R.styleable.SectionDivider_subheading_text);
        boolean dividerVisibility = array.getBoolean(R.styleable.SectionDivider_divider_visible,false);

        setHeader(headingText);
        setSubHeader(subHeadingText);
        isDividerVisible(dividerVisibility);
        array.recycle();
    }

    private void init(Context context)
    {
        SectionDividerBinding binding = SectionDividerBinding.inflate(LayoutInflater.from(context), this, true);
        header = binding.heading;
        subHeader = binding.subHeading;
        divider = binding.horizontalDivider;
        flexButton = binding.flexButton;
    }

    public void setHeader(CharSequence text)
    {
        header.setText(text);
    }

    public void setSubHeader(CharSequence text)
    {
        subHeader.setText(text);
    }

    public void isDividerVisible(boolean value)
    {
        divider.setVisibility(value ? VISIBLE : GONE);
    }

    public void configureButton(String text, int resId)
    {
        flexButton.setText(text);
        flexButton.setImage(resId);
    }
}