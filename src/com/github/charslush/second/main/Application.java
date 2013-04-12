package com.github.charslush.second.main;

import com.github.charslush.second.Copy;
import com.github.charslush.second.Html;
import com.github.charslush.second.Pictures;
import com.github.charslush.second.Text;
import com.github.charslush.second.Thing;

import java.io.IOException;

public final class Application {

    private static final String JPG = "jpg";
    private static final String HTML = "html";
    private static final String TXT = "txt";
    private static final String DOT = ".";

    public static void main(String[] args) throws IOException {
        Copy note = null;

        if (args.length > 0) {
            String enterString = args[0];
            int dotPos = enterString.lastIndexOf(DOT);
            String ext = enterString.substring(dotPos);
            if (JPG.equals(ext)) {
                note = new Pictures(enterString);
            } else if (HTML.equals(ext)) {
                note = new Html(enterString);
            } else if (TXT.equals(ext)) {
                note = new Text(enterString);
            } else {
                note = new Thing(enterString);
            }
            if (note != null) {
                note.open();
            }
        }
    }
}
