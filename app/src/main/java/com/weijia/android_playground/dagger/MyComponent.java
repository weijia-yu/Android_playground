package com.weijia.android_playground.dagger;

import com.weijia.android_playground.Dagger_test;
import com.weijia.android_playground.MainActivity;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    Car buildCar();
    void inject(Dagger_test main);
}
