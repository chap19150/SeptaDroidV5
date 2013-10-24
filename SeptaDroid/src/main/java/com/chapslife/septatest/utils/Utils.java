package com.chapslife.septatest.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Various utility methods
 * Created by kchapman on 10/24/13.
 */
public class Utils {

    /**
     * URL encodes an array of parameters into a query string. Params must have
     * an even number of elements.
     *
     * @param params
     * @return
     */
    public static String urlEncode(String[] params) {
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("Params must have an even number of elements.");
        }

        String result = Constants.EMPTY_STRING;
        try {
            boolean firstTime = true;
            for (int i = 0; i < params.length; i += 2) {
                if (params[i + 1] != null) {
                    if (firstTime) {
                        firstTime = false;
                    } else {
                        result += Constants.AMPERSAND;
                    }
                    result += URLEncoder.encode(params[i], Constants.UTF_CHARSET)
                            + Constants.EQUALS
                            + URLEncoder.encode(params[i + 1], Constants.UTF_CHARSET);
                }
            }
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }

}
