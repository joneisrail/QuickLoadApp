/*
 * Project Name   : NybSys_PTT
 * Created By  	  : skfaisal
 * Created Date	  : 12/27/20 11:00 AM
 * Last edited by :  skfaisal
 * Edited time    : 10/13/20 11:21 AM
 * Purpose        :
 * (c) NybSys Ltd.
 *  ======================
 *
 */

package com.yasir.quickload.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;



import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class BaseFragment extends Fragment {
   public abstract int setLayoutId();
   private ViewDataBinding viewDataBinding;
   public abstract void startUI();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding= DataBindingUtil.inflate(inflater,setLayoutId(),container,false);
        startUI();
        return viewDataBinding.getRoot();
    }




    public ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }


    public String getCurrentTime()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("DD-MM-yyyy HH:mm:ss");
        return df.format(c.getTime());
    }
    public void printCommonLog(String arg1,String arg2)
    {

    }
}
