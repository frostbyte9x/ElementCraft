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

    private void init(Context context) {
        this.context = context;
        inflate(context, R.layout.drop_down_list, this);
        spinner = findViewById(R.id.spinner);
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

    private class DropDownAdapter extends ArrayAdapter<DropDownItems> {
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
            if (convertView == null)
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_down_list_item, parent, false);

            TextView textView = convertView.findViewById(R.id.textView);
            ImageView image = convertView.findViewById(R.id.image);
            FrameLayout frameLayout = convertView.findViewById(R.id.frameLayout);
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
}