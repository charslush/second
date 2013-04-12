package com.github.charslush.second;

import com.github.charslush.second.consts.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public abstract class Copy {

    private final String ext;
    private final String type;
    protected String url;
    protected int count;

    public Copy(String ext, String type, String url) {
        this.ext = ext;
        this.type = type;
        this.url = url;
        this.count++;
    }

    public void save() throws IOException {
        int slashPos = url.lastIndexOf(Constants.SLASH);
        String name = url.substring(slashPos);
        int dotPos = url.lastIndexOf(Constants.DOT);
        String ext = url.substring(dotPos);
        String adress = Constants.DESTINATION_DIR + type + name;
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(adress);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    }

    public abstract void open() throws IOException;
}
