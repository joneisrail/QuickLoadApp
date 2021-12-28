package com.yasir.quickload.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yasir.quickload.R;
import com.yasir.quickload.base.BaseFragment;
import com.yasir.quickload.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends BaseFragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_notifications;
    }

    @Override
    public void startUI() {
        binding = (FragmentNotificationsBinding) getViewDataBinding();
    }



}