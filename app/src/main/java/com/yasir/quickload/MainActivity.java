package com.yasir.quickload;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yasir.quickload.base.BaseActivity;
import com.yasir.quickload.databinding.ActivityMainBinding;
import com.yasir.quickload.service.SerialService;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void startUI(Bundle savedInstanceState) {
        binding = (ActivityMainBinding) getViewDataBinding();


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        startService(new Intent(getActivity(), SerialService.class));
    }



}