package com.yasir.quickload.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.lifecycle.ViewModelProvider;

import com.yasir.quickload.R;
import com.yasir.quickload.base.BaseFragment;
import com.yasir.quickload.databinding.FragmentDashboardBinding;

public class DashboardFragment extends BaseFragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void startUI() {

    }


}