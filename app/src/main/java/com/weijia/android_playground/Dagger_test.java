package com.weijia.android_playground;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.weijia.android_playground.dagger.Car;
import com.weijia.android_playground.dagger.DaggerMyComponent;
import com.weijia.android_playground.dagger.MyComponent;

import javax.inject.Inject;

public class Dagger_test extends Activity {

    @Inject
    Car myCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);
        DaggerMyComponent.builder().build().inject(this);
        //Car myCar = component.buildCar();
        Log.d("car", myCar.printCar());


    }

}
