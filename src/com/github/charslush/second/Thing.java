package com.github.charslush.second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Thing extends Copy {

    private static final String TYPE = "thing";

    public Thing(String url) {
        super(TYPE, url);
        System.out.println("Thing created");
    }

    public void save() throws IOException {
        int slashPos = url.lastIndexOf("/");
        String name = url.substring(slashPos);
        int dotPos = url.lastIndexOf(".");
        String ext = url.substring(dotPos);
        String adress = "~/thing" + name + ext;
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(adress);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    }

    public void open() throws IOException {
    }
}
