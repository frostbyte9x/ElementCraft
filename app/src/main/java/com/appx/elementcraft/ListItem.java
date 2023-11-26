package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListItem extends LinearLayout
{
    private TextView heading;
    private TextView subHeading;
    private ImgView imgView;
    private Button button;
    public ListItem(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ListItem(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
        CommonUtils obj = new CommonUtils();

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.list_item);
        int buttonVisibility = obj.getVisibilityValue(a.getString(R.styleable.list_item_button_visibility));
        int imageVisibility = obj.getVisibilityValue(a.getString(R.styleable.list_item_image_visibility));
        String headingText = a.getString(R.styleable.list_item_heading_text);
        String subHeadingText= a.getString(R.styleable.list_item_subheading_text);
        String buttonText = a.getString(R.styleable.list_item_button_text);
        int height = a.getInt(R.styleable.img_view_height,0);
        int width = a.getInt(R.styleable.img_view_width,0);
        int resId = a.getInt(R.styleable.img_view_res_id,0);

        configure(headingText,subHeadingText,buttonText,height,width
        ,resId,buttonVisibility,imageVisibility);
        a.recycle();
    }

    private void init(Context context)
    {
        inflate(context,R.layout.list_item,this);
        heading = findViewById(R.id.heading);
        subHeading = findViewById(R.id.subHeading);
        button = findViewById(R.id.button);
        imgView = findViewById(R.id.imageView);
    }

    public void configure(String headingText, String subHeadingText,
                          String buttonText, int height, int width, int resId,
                          int buttonVisibility, int imageVisibility)
    {
        imgView.configureImage(width,height,resId);
        heading.setText(headingText);
        subHeading.setText(subHeadingText);
        button.setText(buttonText);
        button.setVisibility(buttonVisibility);
        imgView.setVisibility(imageVisibility);
    }

}