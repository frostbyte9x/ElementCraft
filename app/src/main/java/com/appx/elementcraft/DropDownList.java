package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
    private List<DropDrownItems> items;

    public DropDownList(@NonNull Context context)
    {
        super(context);
        this.context =context;
        init();
    }

    public DropDownList(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context,attrs);
        init();
    }

    private void init() {
        inflate(context, R.layout.drop_down_list, this);
        spinner = findViewById(R.id.spinner);
    }


    public void setItems(List<DropDrownItems> items)
    {
        this.items=items;
        DropDownAdapter adapter = new DropDownAdapter(context);
        spinner.setAdapter(adapter);
    }

    public int getSelectedItemId()
    {
        int position = spinner.getSelectedItemPosition();
        DropDrownItems i = items.get(position);
        return i.getId();
    }

    public class DropDrownItems {
        private String text;
        private int imageId;

        private int id;

        public DropDrownItems(@NonNull int id, String text) {
            this.text = text;
            this.id=id;
            this.imageId=NULL_INT;
        }

        public DropDrownItems(@NonNull int id,int imageId, String text)
        {
            this.imageId = imageId;
            this.text = text;
            this.id=id;
        }

        public String getText() {
            return text;
        }

        public int getImageId()
        {
            return imageId;
        }

        public int getId()
        {
            return id;
        }
    }

    private class DropDownAdapter extends ArrayAdapter<DropDrownItems> {
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
            DropDrownItems item = getItem(position);

            if (item != null)
                textView.setText(item.getText());

            if(item.getImageId() == NULL_INT)
                image.setVisibility(GONE);
            else
                image.setImageResource(item.getImageId());
            return convertView;
        }
    }
}






































//    private ArrayList<DropDrownItems> createItems(String[] items) {
//        ArrayList<DropDrownItems> dropDownItems = new ArrayList<>();
//        for (String text : items) {
//            dropDownItems.add(new DropDrownItems(text));
//        }
//        return dropDownItems;
//    }
//
//    private ArrayList<DropDrownItems> createItems(int[] imageId, String[] items)
//    {
//        ArrayList<DropDrownItems> dropDrownItems = new ArrayList<>();
//        for(int i=0; i<items.length;i++)
//            dropDrownItems.add(new DropDrownItems(imageId[i],items[i]));
//        return dropDrownItems;
//    }