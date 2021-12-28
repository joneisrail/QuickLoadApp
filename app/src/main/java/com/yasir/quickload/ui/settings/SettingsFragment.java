package com.yasir.quickload.ui.settings;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yasir.quickload.R;
import com.yasir.quickload.base.BaseFragment;
import com.yasir.quickload.databinding.FragmentDashboardBinding;
import com.yasir.quickload.databinding.FragmentSettingsBinding;

public class SettingsFragment extends BaseFragment {

    private SettingsViewModel settingsViewModel;
    private ViewDataBinding binding;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    public void startUI() {
        binding = getViewDataBinding();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}