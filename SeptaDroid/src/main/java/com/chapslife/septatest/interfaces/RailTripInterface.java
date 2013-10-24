package com.chapslife.septatest.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kchapman on 10/24/13.
 */
public interface RailTripInterface {

    void onTripReceivedSuccess(JSONArray response);
    void onTripReceivedError(String error);
}
