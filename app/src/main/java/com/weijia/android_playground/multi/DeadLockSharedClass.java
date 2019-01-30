package com.weijia.android_playground.multi;

import android.util.Log;

public class DeadLockSharedClass {
    String shared1 = "";
    String shared2 = "";

    public synchronized void Thread1Action() {
        shared1 = "1";
        shared2 = "2";
        Log.d("multi","finish action1");
    }

    public synchronized void Thread2Action() {
        shared2 = "1";
        shared1 = "2";
        Log.d("multi","finish action2");

    }
}
