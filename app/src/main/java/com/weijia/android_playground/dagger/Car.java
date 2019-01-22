package com.weijia.android_playground.dagger;

import android.util.Log;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

public class Car {
    private Shift mShift;
    private Wheel mWheel;

    @Inject
    public Car(Shift shift,
               @Named("White") Wheel wheel) {
        mShift = shift;
        mWheel = wheel;
    }

    public String printCar () {
        return mShift.getShiftType() + " " + mWheel.getWheelColor();
    }

}
