package com.weijia.android_playground;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.Logger;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Start a new thread by calling new Thread and start
        Thread thread1 = new Thread() {
            public void run() {
                Log.d("log","thread 1 is called");
            }
        };
        thread1.start();

        //2. start a new thread by calling runnable
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("log","thread 2 is called");
            }
        });
        thread2.start();


    }
}
