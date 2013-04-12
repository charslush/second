package com.github.charslush.second.util;

import com.github.charslush.second.consts.Constants;

public class FileUtil {

    public static String extractName(String url) {
        int slashPos = url.lastIndexOf(Constants.SLASH);
        return url.substring(slashPos);
    }

    public static String extractExt(String url) {
        int dotPos = url.lastIndexOf(Constants.DOT);
        return url.substring(dotPos);
    }
}
