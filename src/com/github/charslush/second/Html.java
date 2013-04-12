package com.github.charslush.second;

public class Html extends Copy {

    private static final String TYPE = "html";

    public Html(String url) {
        super(TYPE, url);
        System.out.println("html created");
    }
}
