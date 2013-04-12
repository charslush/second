package com.github.charslush.second;

public class Text extends Copy {

    private static final String TYPE = "txt";

    public Text(String url) {
        super(TYPE, url);
        System.out.println("Text created");
    }
}

