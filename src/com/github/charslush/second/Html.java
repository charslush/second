package com.github.charslush.second;

import java.io.IOException;


public class Html extends Copy {

    private static final String TYPE = "html";

    public Html(String url) {
        super(TYPE, url);
        System.out.println("html created");
    }

    public void save() throws IOException {
    }

    public void open() throws IOException {
    }
}
