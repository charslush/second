package com.github.charslush.second;

public class Pictures extends Copy {

    private static final String TYPE = "pic";

    public Pictures(String url) {
        super(TYPE, url);
        System.out.println("Picture created");
    }
}
