package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PictureView extends LinearLayout {

    private ImageView imageView;

    public PictureView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PictureView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }

    public void init(Context context)
    {
        inflate(context,R.layout.picture_view,this);
        imageView = findViewById(R.id.imageView);
    }
}
