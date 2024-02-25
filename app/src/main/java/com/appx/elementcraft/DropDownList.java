package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.DropDownListBinding;
import com.appx.elementcraft.databinding.DropDownListItemBinding;

public class DropDownList extends LinearLayout {
    private Spinner spinner;
    private Context context;
    private static final int NULL_INT = -99;
    private List<DropDownItems> items;

    public DropDownList(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public DropDownList(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }

    private void init(Context context)
    {
        this.context = context;
        DropDownListBinding binding = DropDownListBinding.inflate(LayoutInflater.from(context),this,true);
        spinner = binding.spinner;
    }

    public void setItems(List<DropDownItems> items)
    {
        this.items=items;
        DropDownAdapter adapter = new DropDownAdapter(context);
        spinner.setAdapter(adapter);
    }

    public int getSelectedItemId()
    {
        int position = spinner.getSelectedItemPosition();
        DropDownItems i = items.get(position);
        return i.getId();
    }

    public int getSelectedItemPosition()
    {
        return spinner.getSelectedItemPosition();
    }

    private class DropDownAdapter extends ArrayAdapter<DropDownList.DropDownItems> {
        private DropDownAdapter(Context context) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        private View initView(int position, View convertView, ViewGroup parent) {
            DropDownListItemBinding binding;

            if(convertView == null)
            {
                binding = DropDownListItemBinding.inflate(LayoutInflater.from(context),parent,true);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            }
            else
                binding=(DropDownListItemBinding)convertView.getTag();

            TextView textView = binding.textView;
            ImageView image = binding.imageView;
            FrameLayout frameLayout = binding.frameLayout;
            DropDownItems item = getItem(position);

            if (item != null)
                textView.setText(item.getText());

            if(item.getImageId() == NULL_INT)
                frameLayout.setVisibility(GONE);
            else
                image.setImageResource(item.getImageId());
            return convertView;
        }
    }

    public static class DropDownItems
    {
        private String text;
        private int imageId;
        private int id;
        private static final int NULL_INT = -99;

        public DropDownItems(@NonNull int id, String text)
        {
            this.text =text;
            this.id=id;
            this.imageId = NULL_INT;
        }

        public DropDownItems(@NonNull int id, int imageId,String text)
        {
            this.text = text;
            this.id=id;
            this.imageId=imageId;
        }

        public String getText()
        {
            return text;
        }

        public int getImageId()
        {
            return imageId;
        }

        public int getId() {
            return id;
        }

    }
}