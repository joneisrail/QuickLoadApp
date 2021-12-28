/*
 * Project Name   : NybSys_PTT
 * Created By  	  : skfaisal
 * Created Date	  : 12/27/20 11:00 AM
 * Last edited by :  skfaisal
 * Edited time    : 12/6/20 3:16 PM
 * Purpose        :
 * (c) NybSys Ltd.
 *  ======================
 *
 */

package com.yasir.quickload.base;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String IMAGE_DIRECTORY = "santra ptt";

    public abstract int setLayoutId();

    private ViewDataBinding viewDataBinding;

    public abstract void startUI(Bundle savedInstanceState);




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, setLayoutId());
       // initTrueTime();
        startUI(savedInstanceState);
    }

    public Context getActivity() {
        return viewDataBinding.getRoot().getContext();
    }


    public ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }

    //setting up back functionality with custom view
    public void setBackPressViews(View... Views) {
        for (View v : Views) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    //setting up back functionality with custom view
    public void setClickListeners(View... Views) {
        for (View v : Views) {
            v.setOnClickListener(this);
        }
    }

    public void showLongToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void resetViews(View... Views) {
        for (View v : Views) {
            boolean b1 = v instanceof TextView;
            if (b1 == true) {
                TextView textView = (TextView) v;

                textView.setText("");


            }
            boolean b2 = v instanceof EditText;
            if (b2 == true) {
                EditText editText = (EditText) v;

                editText.setText("");


            }
            boolean b3 = v instanceof ImageView;

            if (b3 == true) {
                ImageView imageView = (ImageView) v;

                imageView.setVisibility(View.GONE);

            }
        }
    }

    public boolean getValidation(String validationMsg, View... Views) {
        boolean flag = true;
        for (View v : Views) {
            boolean b1 = v instanceof TextView;
            if (b1 == true) {
                TextView textView = (TextView) v;
                if (textView.getText().toString().trim().isEmpty()) {
                    textView.setError(validationMsg);
                    flag = false;

                }
            }
            boolean b2 = v instanceof EditText;
            if (b2 == true) {
                EditText editText = (EditText) v;
                if (editText.getText().toString().trim().isEmpty()) {
                    editText.setError(validationMsg);
                    flag = false;

                }
            }
            boolean b3 = v instanceof ImageView;

            if (b3 == true) {
                ImageView imageView = (ImageView) v;
                if (imageView.getVisibility() == View.GONE || imageView.getVisibility() == View.INVISIBLE) {
                    flag = false;
                }
            }
        }
        return flag;
    }


    public String getCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(c.getTime());
    }

    @Override
    public void onClick(View v) {

    }

    public File convertBitmapToFile(String filename, ImageView imageView) {
        //create a file to write bitmap data
        File f = new File(getBaseContext().getCacheDir(), filename);
        try {

            f.createNewFile();

//Convert bitmap to byte array
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Objects.requireNonNull(fos).write(bitmapdata);
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
        return f;
    }




}
