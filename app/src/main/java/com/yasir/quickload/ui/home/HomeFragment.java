package com.yasir.quickload.ui.home;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import com.yasir.quickload.R;
import com.yasir.quickload.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    AlertDialog.Builder builder;
    String operator="";
    String mob="";
    String number="";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Yes",(dialog, which) -> {

        });
        builder.setNegativeButton("No",(dialog, which) -> {

        });

        binding.btnOkay.setOnClickListener(v -> {
            mob = binding.spOperator.getSelectedItem().toString();
            number=binding.spOperator.getSelectedItem().toString();

            builder.setMessage("Do you want recharge \n "+mob);
            builder.setTitle("Confirmation");
            builder.show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}