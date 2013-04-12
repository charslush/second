package com.github.charslush.second;

import com.github.charslush.second.consts.Constants;
import com.github.charslush.second.util.FileUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public abstract class Copy {

    private final String type;
    protected String url;
    protected String name;
    protected String ext;
    protected int count;

    public Copy(String type, String url) {
        this.type = type;
        this.url = url;
        this.count++;
        processUrl();
    }

    public void save() throws IOException {
        String adress = Constants.DESTINATION_DIR + type + name;
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(adress);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    }

    public abstract void open() throws IOException;

    private void processUrl() {
        name = FileUtil.extractName(url);
        ext = FileUtil.extractExt(url);
    }
}
