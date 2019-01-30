package com.weijia.android_playground.multi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.weijia.android_playground.R;

public class DeadLockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead_lock);
        final DeadLockSharedClass deadlock = new DeadLockSharedClass();

        final TreeNode parent = new TreeNode();
        final TreeNode children = new TreeNode();

        Thread thread1 = new Thread() {
            public void run() {
                parent.addChild(children);
            }
        };


        //2. start a new thread by calling runnable
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                children.setParent(parent);
            }
        });
        thread1.start();
        thread2.start();
    }
}
