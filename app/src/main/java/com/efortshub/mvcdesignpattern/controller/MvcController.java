package com.efortshub.mvcdesignpattern.controller;

import android.view.View;

import com.efortshub.mvcdesignpattern.MainActivity;
import com.efortshub.mvcdesignpattern.model.MvcModel;

/**
 * Created by H. Bappi on  8:47 AM  3/22/22.
 * Contact email:
 * contact@efortshub.com
 * bappi@efortshub.com
 * contact.efortshub@gmail.com
 * github: https://github.com/hbappi
 * website: efortshub.com
 * Copyright (c) 2022 eFortsHub . All rights reserved.
 **/
public class MvcController {
    MainActivity mainActivity;
    MvcModel model;


    public MvcController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.model = new MvcModel();
    }


    //trigger this to get MvcModel data from server or from somewhere. for this, I am simply getting from local variable after random delay
    public void sendRequest() {
        mainActivity.binding.btnStartRequest.setEnabled(false);
        mainActivity.binding.pb.setVisibility(View.VISIBLE);
        model.getResponse(this);
    }

    //this method will get triggered whenever server data get loaded inside MvcModel getResponse Method
    public void getResponse(int delay, String response) {
        //load UI of main Activity when data ready
        mainActivity.binding.pb.setVisibility(View.INVISIBLE);
        mainActivity.binding.btnStartRequest.setEnabled(true);
        mainActivity.binding.tvDelayed.setText(delay+" Seconds");
        mainActivity.binding.tvResponse.setText(response);

    }
}
