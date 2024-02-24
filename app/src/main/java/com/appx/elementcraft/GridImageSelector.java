package com.appx.elementcraft;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import com.appx.elementcraft.databinding.GridImageSelectorBinding;
import com.appx.elementcraft.databinding.GridItemBinding;

public class GridImageSelector extends LinearLayout
{
    private Spinner spinner;

    public GridImageSelector(Context context)
    {
        super(context);
        init(context);
    }

    public GridImageSelector(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        GridImageSelectorBinding binding = GridImageSelectorBinding.inflate(inflater, this, true);
        spinner = binding.spinner;
    }

    public void configureImageSelector(Context context, List<Integer> imageList)
    {
        ImageAdapter adapter = new ImageAdapter(context, imageList);
        spinner.setAdapter(adapter);
    }

    public static class ImageAdapter extends BaseAdapter
    {
        private Context context;
        private List<Integer> list;

        public ImageAdapter(Context context, List<Integer> list)
        {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount()
        {
            return list.size();
        }

        @Override
        public Object getItem(int position)
        {
            return list.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder viewHolder;

            if(convertView == null)
            {
                LayoutInflater inflater = LayoutInflater.from(context);
                GridItemBinding binding = GridItemBinding.inflate(inflater, parent, false);
                viewHolder = new ViewHolder(binding);
                convertView = binding.getRoot();
                convertView.setTag(viewHolder);
            }
            else
                viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.bind(list.get(position));

            return convertView;
        }

        private static class ViewHolder
        {
            private final ImageView imageView;

            ViewHolder(GridItemBinding binding)
            {
                imageView = binding.imageView;
            }

            void bind(int imageResource)
            {
                imageView.setImageResource(imageResource);
            }
        }
    }
}