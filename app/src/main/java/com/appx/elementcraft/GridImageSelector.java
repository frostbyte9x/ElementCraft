package com.appx.elementcraft;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appx.elementcraft.databinding.GridImageSelectorBinding;
import com.appx.elementcraft.databinding.GridItemBinding;

public class GridImageSelector extends DialogFragment
{
    private RecyclerView recView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GridImageSelectorBinding binding = GridImageSelectorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        recView = binding.recView;
        return view;
    }

    public void configureImageSelector(Context context, List<Integer> imageList)
    {
        recView.setLayoutManager(new GridLayoutManager(context,5));
        recView.setAdapter(new GridImageAdapter(context,imageList));
    }

    public static class GridImageAdapter extends RecyclerView.Adapter<GridImageAdapter.ViewHolder>
    {
        private Context context;
        private List<Integer> list;

        public GridImageAdapter(Context context, List<Integer> list)
        {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            GridItemBinding binding = GridItemBinding.inflate(inflater, parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position)
        {
            holder.bind(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        private static class ViewHolder extends RecyclerView.ViewHolder
        {
            private final ImageView imageView;

            public ViewHolder(GridItemBinding binding)
            {
                super(binding.getRoot());
                imageView = binding.imageView;
            }

            public void bind(int imageResource)
            {
                imageView.setImageResource(imageResource);
            }
        }
    }
}