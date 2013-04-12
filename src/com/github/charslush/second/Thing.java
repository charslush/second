package com.github.charslush.second;

public class Thing extends Copy {

    private static final String TYPE = "thing";

    public Thing(String url) {
        super(TYPE, url);
        System.out.println("Thing created");
    }
}
