package com.github.charslush.second;

import com.github.charslush.second.consts.Constants;
import com.github.charslush.second.util.FileUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public abstract class Copy {

    protected final String url;
    protected final String name;
    protected final String ext;
    protected int count;
    private final String type;

    public Copy(String type, String url) {
        this.type = type;
        this.url = url;
        this.count++;
        this.name = FileUtil.extractName(url);
        this.ext = FileUtil.extractExt(url);
    }

    public void save() throws IOException {
        String adress = Constants.DESTINATION_DIR + Constants.SLASH + type + Constants.SLASH + name;
        FileOutputStream fos = new FileOutputStream(adress);
        fos.getChannel().transferFrom(open(), 0, 1 << 24);
    }

    public ReadableByteChannel open() {
        ReadableByteChannel toReturn = null;
        URL url1 = null;
        try {
            url1 = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (url1 != null) {
            try {
                toReturn = Channels.newChannel(url1.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toReturn;
    }
}
