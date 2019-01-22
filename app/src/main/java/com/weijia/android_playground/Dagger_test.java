package com.weijia.android_playground;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.weijia.android_playground.dagger.Car;
import com.weijia.android_playground.dagger.DaggerMyComponent;
import com.weijia.android_playground.dagger.MyComponent;

public class Dagger_test extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);
        MyComponent component = DaggerMyComponent.create();
        Car myCar = component.buildCar();
        Log.d("car", myCar.printCar());
    }

}
