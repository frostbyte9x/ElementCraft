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
//    private ListItemBinding binding;
    private TextView heading;
    private TextView subHeading;
//    private ImgView imgView;
//    private FlexButton flexButton;
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
//        CommonUtils obj = new CommonUtils();

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ListItem);
//        int buttonVisibility = obj.getVisibilityValue(Objects.requireNonNull(a.getString(R.styleable.ListItem_button_visibility)));
//        int imageVisibility = obj.getVisibilityValue(Objects.requireNonNull(a.getString(R.styleable.ListItem_image_visibility)));
//        String headingText = a.getString(R.styleable.ListItem_heading_text);
//        String subHeadingText= a.getString(R.styleable.ListItem_subheading_text);
//        String buttonText = a.getString(R.styleable.ListItem_button_text);
//        int height = a.getInt(R.styleable.ListItem_height,0);
//        int width = a.getInt(R.styleable.ListItem_width,0);
//        int resId = a.getInt(R.styleable.ListItem_res_id,0);
//
//        configure(headingText,subHeadingText,buttonText,height,width,resId,buttonVisibility,imageVisibility);
        a.recycle();
    }

    private void init(Context context)
    {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(context),this,true);
        heading = binding.heading;
        subHeading = binding.subHeading;
//        inflate(context,R.layout.list_item,this);
//        heading = findViewById(R.id.heading);
//        subHeading = findViewById(R.id.subHeading);
//        flexButton = findViewById(R.id.button);
//        imgView = findViewById(R.id.imageView);
    }

//    public void configure(String headingText, String subHeadingText, String buttonText, int height, int width, int resId, int buttonVisibility, int imageVisibility)
//    {
////        imgView.configureImage(width,height,resId);
//        heading.setText(headingText);
//        subHeading.setText(subHeadingText);
//        flexButton.setText(buttonText);
//        flexButton.setVisibility(buttonVisibility);
////        imgView.setVisibility(imageVisibility);
//    }

    public void configure(String headingText,String subHeadingText)
    {
//        flexButton.setVisibility(GONE);
//        imgView.setVisibility(GONE);
        heading.setText(headingText);
        subHeading.setText(subHeadingText);
    }
}