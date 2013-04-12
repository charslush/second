package com.github.charslush.second.main;

import com.github.charslush.second.Copy;
import com.github.charslush.second.Html;
import com.github.charslush.second.Pictures;
import com.github.charslush.second.Text;
import com.github.charslush.second.Thing;

import java.io.IOException;

public class Application {

    private static final String JPG = "jpg";
    private static final String HTML = "html";
    private static final String TXT = "txt";
    private static final String DOT = ".";

    public static void main(String[] args) throws IOException {
        Copy copyObject = new Html("");

        if (args.length > 0) {
            String enterString = args[0];
            int dotPos = enterString.lastIndexOf(DOT);
            String ext = enterString.substring(dotPos);
            if (ext.equals(JPG)) {
                Copy pic = new Pictures(enterString);
                pic.open();
            }
            if (ext.equals(HTML)) {
                Copy html = new Html(enterString);
                html.open();
            }

            if (ext.equals(TXT)) {
                Copy txt = new Text(enterString);
                txt.open();
            } else {
                Copy thing = new Thing(enterString);
                thing.open();
            }
        }
    }

}
