package com.efortshub.mvcdesignpattern.model;

import android.os.Handler;
import android.os.Looper;

import com.efortshub.mvcdesignpattern.controller.MvcController;

import java.util.Random;

/**
 * Created by H. Bappi on  8:54 AM  3/22/22.
 * Contact email:
 * contact@efortshub.com
 * bappi@efortshub.com
 * contact.efortshub@gmail.com
 * github: https://github.com/hbappi
 * website: efortshub.com
 * Copyright (c) 2022 eFortsHub . All rights reserved.
 **/
public class MvcModel {

    String[] arr = new String[]{"I am no dummy, mate, that's for sure.",
            "To me, cricket is a simple game. Keep it simple and just go out and play.",
            "I just play because I love playing and I try and take as many wickets as I can.",
            "The public want to see people play an exciting brand of cricket."
    };



    //this method is nothing but just simulate server response by waiting random seconds.
    public void getResponse(MvcController mvcController){
        new Thread(() -> {
            Random random = new Random();
            int i = random.nextInt(10);
            if (i<0) i=2; else if(i<2) i+=2;

            try {
                Thread.sleep(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int j = random.nextInt(3);
            String response = arr[j];
            int finalI = i;
            new Handler(Looper.getMainLooper()).post(() -> mvcController.getResponse(finalI, response));


        }).start();
    }
}
