package com.weijia.android_playground;

import com.weijia.android_playground.dagger.Wheel;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class DaggerMockitoTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    Wheel mWheel;

    @Test
    public void test_mockito() {
        when(mWheel.getWheelColor()).thenReturn("predefined");
        Assert.assertEquals(mWheel.getWheelColor(),"predefined");
    }
}
