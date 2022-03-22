package com.efortshub.mvcdesignpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.efortshub.mvcdesignpattern.controller.MvcController;
import com.efortshub.mvcdesignpattern.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    MvcController mvcController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mvcController = new MvcController(this);

        binding.btnStartRequest.setOnClickListener(view -> {
            mvcController.sendRequest();
        });



    }
}