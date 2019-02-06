package com.weijia.android_playground.mockito;

public class ActionHandler {

    private Service mService;

    public ActionHandler(Service service) {
        mService = service;
    }
    public void doAction() {
        mService.doAction("test", new Callback<String>() {
            @Override
            public void reply(String response) {

            }
        });
    }
}
