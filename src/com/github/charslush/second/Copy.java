package com.github.charslush.second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public abstract class Copy {

    private static final String SLASH = "/";
    private static final String DOT = ".";
    private static final String EXT = "";

    protected String url;
    protected int count;

    public Copy(String url) {
        this.url = url;
        this.count++;
    }

    public void save() throws IOException {
        int slashPos = url.lastIndexOf(SLASH);
        String name = url.substring(slashPos);
        int dotPos = url.lastIndexOf(DOT);
        String ext = url.substring(dotPos);
        String adress = "~/html" + name;
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(adress);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    }

    public abstract void open() throws IOException;
}
