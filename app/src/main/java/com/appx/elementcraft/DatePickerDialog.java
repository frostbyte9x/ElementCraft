package com.appx.elementcraft;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appx.elementcraft.databinding.DatePickerDialogBinding;
import java.util.ArrayList;
import java.util.List;

public class DatePickerDialog extends AlertDialog
{
    private DatePickerDialogBinding binding;
    private RecyclerView recView;
    private DateAdapter adapter;
    private List<String> dateList;
    public DatePickerDialog(@NonNull Context context)
    {
        super(context);
    }

    private void init(Context context)
    {
        dateList = new ArrayList<>();
        adapter = new DateAdapter(dateList);

//        binding = DatePickerDialogBinding.inflate(LayoutInflater.from(context));
//        setView(binding.getRoot());
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.date_picker_dialog,null);
        setView(dialogView);

        //recView = dialogView.findViewById(R.id.recView);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new GridLayoutManager(context,7,GridLayoutManager.HORIZONTAL,false));
    }

    private class DateAdapter extends RecyclerView.Adapter<DateViewHolder>
    {
        private List<String> dateList;

        DateAdapter(List<String> dateList)
        {
            this.dateList = dateList;
        }

        @NonNull
        @Override
        public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
            holder.bind(dateList.get(position));
        }

        @Override
        public int getItemCount() {
            return dateList.size();
        }
    }

    private static class DateViewHolder extends RecyclerView.ViewHolder
    {
        DateViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }

        void bind(String item)
        {

        }
    }
}
