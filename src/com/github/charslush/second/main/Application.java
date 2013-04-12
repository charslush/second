package com.github.charslush.second.main;

import com.github.charslush.second.Copy;
import com.github.charslush.second.Html;
import com.github.charslush.second.Pictures;
import com.github.charslush.second.Text;
import com.github.charslush.second.Thing;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Copy copyObject = new Html("");

        if (args.length > 0) {
            String enterString = args[0];
            int dotPos = enterString.lastIndexOf(".");
            String ext = enterString.substring(dotPos);
            if (ext.equals("jpg")) {
                Copy pic = new Pictures(enterString);
                pic.open();
            }
            if (ext.equals("html")) {
                Copy html = new Html(enterString);
                html.open();
            }

            if (ext.equals("txt")) {
                Copy txt = new Text(enterString);
                txt.open();
            } else {
                Copy thing = new Thing(enterString);
                thing.open();
            }
        }
    }

}
