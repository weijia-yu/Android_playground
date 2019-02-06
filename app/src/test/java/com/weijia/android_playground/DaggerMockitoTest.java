package com.weijia.android_playground;

import android.app.Person;

import com.weijia.android_playground.dagger.Wheel;
import com.weijia.android_playground.mockito.ActionHandler;
import com.weijia.android_playground.mockito.Callback;
import com.weijia.android_playground.mockito.Service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DaggerMockitoTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    Wheel mWheel;

    @Test
    public void test_mockito() {
        when(mWheel.getWheelColor()).thenReturn("predefined");
        assertEquals(mWheel.getWheelColor(),"predefined");
    }

    @Test
    public void Verify_WithList_AlwaysSuccess() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        //ActionHandler handler = new ActionHandler(service);
    }

    @Test
    public void Stub_WithList_AlwaysSuccess() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("first");
        mockedList.get(0);
        verify(mockedList).get(0);
    }

    @Test
    public void ArgsMatch_WithList_AlwaysSuccess() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        mockedList.add("one");
        mockedList.add("morethanfive");
        verify(mockedList).add(argThat((String someString) -> someString.length() > 5));
    }

    @Test
    public void VerifyTimes_WithList_AlwaysSuccess() {
        List mockedList = mock(List.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");

    }

    @Test
    public void CaptureArgs_WithList_AlwaysSuccess() {

        List mockedList = mock(List.class);
        mockedList.add("three time");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        verify(mockedList).add(argument.capture());
        assertEquals("three time", argument.getValue());
    }

    @Test
    public void Callback_WithService_AlwaysSuccess() {
        Service service = mock(Service.class);
        ArgumentCaptor<Callback<String>> callbackCaptor = ArgumentCaptor.forClass(Callback.class);
        //ActionHandler handler = new ActionHandler(service);
        service.doAction("haha", new Callback<String>() {
            @Override
            public void reply(String response) {
                Assert.assertEquals(response,"test");
            }
        });
        verify(service).doAction(anyString(), callbackCaptor.capture());

        Callback<String> callback = callbackCaptor.getValue();
        callback.reply("test");
    }

}
