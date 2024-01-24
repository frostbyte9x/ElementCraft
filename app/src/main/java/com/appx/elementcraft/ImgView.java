package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImgView extends LinearLayout {

    private ImageView imageView;

    public ImgView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ImgView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ImgView);
        int height = a.getInt(R.styleable.ImgView_height,0);
        int width = a.getInt(R.styleable.ImgView_width,0);
        int resId = a.getInt(R.styleable.ImgView_res_id,0);
        configureImage(width,height,resId);
        a.recycle();
    }

    private void init(Context context)
    {
//        setImage(0);
        Log.i("ImgView","Inside init method.");
        inflate(context,R.layout.img_view,this);
        imageView = findViewById(R.id.imageView);
        Log.i("ImgView","Exiting init method.");

    }

    public void configureImage(int width, int height,int resId)
    {
        if(height == 0 || width == 0)
            setVisibility(View.GONE);
        else
        {
            Log.i("ImgView","Trying to resize image.");
            setImage(resId);
            float scale = getResources().getDisplayMetrics().density;
            width = (int)(width * scale + 0.5f);
            height = (int)(height * scale + 0.5f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
            Log.i("ImgView","Exiting configure Image method.");

        }
    }

//    public void setVisibility(int visId)
//    {
//        super.setVisibility(visId);
//    }

    public void setImage(int resId)
    {
        Log.i("ImgView","Inside setImage method.");
        imageView.setImageResource(resId);
        Log.i("ImgView","Exiting setImage method.");

    }

    public void setScaleType()
    {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
