package com.appx.elementcraft;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;
import com.appx.elementcraft.databinding.FormDialogBinding;

public class FormDialog extends DialogFragment {

    public interface Form {
        void onSubmit();
        ViewBinding createViewBinding(LayoutInflater inflater, ViewGroup container);
    }

    private Form form;
    private FormDialogBinding binding;
    private TextView heading;
    private FrameLayout formContainer;
    private FlexButton button;

    public void setForm(Form form) {
        this.form = form;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FormDialogBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        heading = binding.heading;
        formContainer = binding.formContainer;
        button = binding.button;
        formContainer.removeAllViews();

        if (form != null)
            formContainer.addView(form.createViewBinding(inflater,container).getRoot());

        button.setOnClickListener(v ->
        {
            if(form !=null)
            {
                form.onSubmit();
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getDialog() != null)
        {
            Window window = getDialog().getWindow();
            if (window != null)
            {
                window.setBackgroundDrawableResource(R.drawable.dialog_background);
                WindowManager.LayoutParams params = window.getAttributes();
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                params.gravity = Gravity.CENTER;
                window.setAttributes(params);
            }
        }
    }

    public void setHeading(String charSequence)
    {
        heading.setText(charSequence);
    }
}
