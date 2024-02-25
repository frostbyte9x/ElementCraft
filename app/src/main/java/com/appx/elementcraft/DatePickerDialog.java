package com.appx.elementcraft;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appx.elementcraft.databinding.DatePickerDialogBinding;
import com.appx.elementcraft.databinding.DatePickerItemBinding;
import java.util.ArrayList;
import java.util.List;

public class DatePickerDialog extends DialogFragment
{
    private RecyclerView recView;
    private ImageView leftButton;
    private ImageView rightButton;
    private TextView monthView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        DatePickerDialogBinding binding = DatePickerDialogBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        recView = binding.recView;
        leftButton = binding.leftButton;
        rightButton = binding.rightButton;
        monthView = binding.monthView;




        return view;
    }

    private static class DataItems
    {
        private String date;
        private int dateType;
        public DataItems(String date, int dateType)
        {
            this.date = date;
            this.dateType = dateType;
        }

        public String getDate()
        {
            return date;
        }

        public int getDateType()
        {
            return dateType;
        }
    }

    private static class DateViewAdapter extends RecyclerView.Adapter<DateViewAdapter.ViewHolder>
    {
        public DateViewAdapter()
        {
            
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        private static class ViewHolder extends RecyclerView.ViewHolder
        {
            private ImageView selectionIndicator;
            private TextView dateView;

            public ViewHolder(DatePickerItemBinding binding)
            {
                super(binding.getRoot());
            }

            public void bind()
            {

            }
        }
    }
}
