package com.appx.elementcraft;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;

import java.util.Objects;

public class InfoDialog extends AlertDialog
{
    public InfoDialog(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    private void init(Context context)
    {
        View customView = LayoutInflater.from(context).inflate(R.layout.info_dialog,null);
        Objects.requireNonNull(getWindow()).setBackgroundDrawableResource(R.drawable.dialog_background);
        setView(customView);
    }
}