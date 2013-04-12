package com.github.charslush.second;

import java.io.IOException;

public abstract class Copy {

    protected String url;
    protected int count;

    public Copy(String url) {
        this.url = url;
        this.count++;
    }

    public abstract void save() throws IOException;

    public abstract void open() throws IOException;
}
