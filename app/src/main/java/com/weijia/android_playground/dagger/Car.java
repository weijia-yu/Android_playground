package com.weijia.android_playground.dagger;

import android.util.Log;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

public class Car {
    private Shift mShift;
    private Wheel mWheel;

    private String mName;

    public Car() {
//        mShift = shift;
//        mWheel = wheel;
        mName = "default";
    }

    @Inject
    public Car(String name) {
        mName = name;
    }

//    public String printCar () {
//        return mShift.getShiftType() + " " + mWheel.getWheelColor();
//    }

    public String printCar () {
        return  mName;
    }

}
