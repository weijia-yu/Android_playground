package com.weijia.android_playground.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    public Shift provideShifter() {
        return new Shift();
    }

    @Provides
    @Named("Black")
    public Wheel provideBlackWheel() {
        return new Wheel("black");
    }

    @Provides
    @Named("White")
    public Wheel provideWhiteWheel() {
        return new Wheel("white");

    }
}