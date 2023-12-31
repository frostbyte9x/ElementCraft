package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageCompilation extends FrameLayout
{
    private ImgView image1,image2,image3;
    public ImageCompilation(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public ImageCompilation(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context,R.layout.image_compilation,this);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image1.setScaleType();
        image2.setScaleType();
        image3.setScaleType();
    }

    public void setImage1(int resId)
    {
        image1.setImage(resId);
    }

    public void setImage2(int resId)
    {
        image2.setImage(resId);
    }

    public void setImage3(int resId)
    {
        image3.setImage(resId);
    }
}