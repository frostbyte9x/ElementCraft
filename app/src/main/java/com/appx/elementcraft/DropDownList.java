package com.appx.elementcraft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DropDownList extends LinearLayout {

    private Spinner spinner;
    private Context context;

    public DropDownList(@NonNull Context context)
    {
        super(context);
        this.context =context;
        init();
    }

    private void init() {
        inflate(context, R.layout.drop_down_list, this);
        spinner = findViewById(R.id.spinner);
    }


    public void setItems(String[] items)
    {
        DropDownAdapter adapter = new DropDownAdapter(context, createItems(items));
        spinner.setAdapter(adapter);
    }

    public void setItems(int[] imageId, String[] items)
    {
        DropDownAdapter adapter = new DropDownAdapter(context, createItems(imageId,items));
    }

    public int getSelectedItemPosition()
    {
        return spinner.getSelectedItemPosition();
    }

    private ArrayList<DropDrownItems> createItems(String[] items) {
        ArrayList<DropDrownItems> dropDownItems = new ArrayList<>();
        for (String text : items) {
            dropDownItems.add(new DropDrownItems(text));
        }
        return dropDownItems;
    }

    private ArrayList<DropDrownItems> createItems(int[] imageId, String[] items)
    {
        ArrayList<DropDrownItems> dropDrownItems = new ArrayList<>();
        for(int i=0; i<items.length;i++)
            dropDrownItems.add(new DropDrownItems(imageId[i],items[i]));
        return dropDrownItems;
    }

    private class DropDrownItems {
        private String text;
        private int imageId;

        private DropDrownItems(String text) {
            this.text = text;
        }

        private DropDrownItems(int imageId, String text)
        {
            this.imageId = imageId;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public int getImageId()
        {
            return imageId;
        }
    }

    private class DropDownAdapter extends ArrayAdapter<DropDrownItems> {
        private DropDownAdapter(Context context, ArrayList<DropDrownItems> list) {
            super(context, 0, list);
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
            DropDrownItems item = getItem(position);

            if (item != null)
                textView.setText(item.getText());

            if(item.getImageId() == 0)
                image.setVisibility(GONE);
            else
                image.setImageResource(item.getImageId());
            return convertView;
        }
    }
}
