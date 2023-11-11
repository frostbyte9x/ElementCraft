package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AmountDescriptionView extends LinearLayout
{
    private TextView amount;
    private TextView description;
    public AmountDescriptionView(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public AmountDescriptionView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.amount_description_view);

        String amountText = a.getString(R.styleable.amount_description_view_amount);
        String descriptionText = a.getString(R.styleable.amount_description_view_description);

        if(amountText != null)
            setAmount(amountText);
        if(descriptionText !=null)
            setDescription(descriptionText);
        a.recycle();
    }

    public void init(Context context)
    {
        inflate(context,R.layout.amount_description_view,this);
        amount = findViewById(R.id.amount);
        description = findViewById(R.id.description);
    }

    public void setAmount(CharSequence amountText)
    {
        amount.setText(amountText);
    }

    public void setDescription(CharSequence descriptionText)
    {
        description.setText(descriptionText);
    }
}
