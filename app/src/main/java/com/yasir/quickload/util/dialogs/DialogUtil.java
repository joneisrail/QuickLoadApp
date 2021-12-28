package com.yasir.quickload.util.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yasir.quickload.R;

import java.util.List;
import java.util.Objects;

public class DialogUtil {
    private static DialogAdapter dialogAdapter = new DialogAdapter();
    public static void showMessageDialog(Context context, String title, List<String> body, DialogButtonClickListener dialogButtonClickListener) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View alertLayout = inflater.inflate(R.layout.dialog_paired_devices, null);

        TextView contentTitle = alertLayout.findViewById(R.id.content_title);
        RecyclerView contentRecyclerView = alertLayout.findViewById(R.id.rename_chan_ET);
        dialogAdapter.clear();
        contentRecyclerView.setAdapter(dialogAdapter);
        dialogAdapter.addItems(body);
        contentRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        TextView notNowBtn = alertLayout.findViewById(R.id.btn_not_now);
        TextView confirmBtn = alertLayout.findViewById(R.id.btn_confirm);



        contentTitle.setText(title);


        AlertDialog.Builder alertPermissionBuilder = new AlertDialog.Builder(context);
        alertPermissionBuilder.setView(alertLayout);
        alertPermissionBuilder.setCancelable(false);


        Dialog alertPermissionDialog = alertPermissionBuilder.create();
        Objects.requireNonNull(alertPermissionDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertPermissionDialog.show();

        notNowBtn.setOnClickListener(v -> {
            alertPermissionDialog.dismiss();
            if (dialogButtonClickListener != null) {
                dialogButtonClickListener.onNotNowButtonCLicked();
            }
        });
        confirmBtn.setOnClickListener(v -> {
            alertPermissionDialog.dismiss();
            if (dialogButtonClickListener != null) {
                dialogButtonClickListener.onConfirmButtonClicked();
            }
        });
    }


    public static Dialog showMessageDialog(Context context, String title, String body, DialogButtonClickListener dialogButtonClickListener, String textNotNow, String textConfirm) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View alertLayout = inflater.inflate(R.layout.dialog_paired_devices, null);

        TextView contentTitle = alertLayout.findViewById(R.id.content_title);
        TextView contentText = alertLayout.findViewById(R.id.rename_chan_ET);

        TextView notNowBtn = alertLayout.findViewById(R.id.btn_not_now);
        TextView confirmBtn = alertLayout.findViewById(R.id.btn_confirm);

        notNowBtn.setText(textNotNow);
        confirmBtn.setText(textConfirm);


        contentText.setText(body);
        contentTitle.setText(title);


        AlertDialog.Builder alertPermissionBuilder = new AlertDialog.Builder(context);
        alertPermissionBuilder.setView(alertLayout);
        alertPermissionBuilder.setCancelable(true);


        Dialog alertPermissionDialog = alertPermissionBuilder.create();
        Objects.requireNonNull(alertPermissionDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertPermissionDialog.show();

        notNowBtn.setOnClickListener(v -> {
            alertPermissionDialog.dismiss();
            if (dialogButtonClickListener != null) {
                dialogButtonClickListener.onNotNowButtonCLicked();
            }
        });
        confirmBtn.setOnClickListener(v -> {
            alertPermissionDialog.dismiss();
            if (dialogButtonClickListener != null) {
                dialogButtonClickListener.onConfirmButtonClicked();
            }
        });
        return alertPermissionDialog;
    }

    public interface DialogButtonClickListener {
        void onNotNowButtonCLicked();

        void onConfirmButtonClicked();
    }
}
