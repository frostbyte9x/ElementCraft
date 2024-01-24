package com.appx.elementcraft;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.AmountDescriptionViewBinding;

public class AmountDescriptionView extends LinearLayout
{
    private AmountDescriptionViewBinding binding;
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
        binding = AmountDescriptionViewBinding.inflate(LayoutInflater.from(context),this,true);
        amount = binding.amount;
        description = binding.description;
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
