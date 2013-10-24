package com.chapslife.septatest.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.chapslife.septatest.interfaces.RailTripInterface;
import com.chapslife.septatest.utils.Constants;
import com.chapslife.septatest.utils.RequestManager;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kchapman on 10/24/13.
 */
public class SeptaApi {

    public static final String SEPTA_BASE_URL = "http://www3.septa.org/hackathon";
    public static final String NEXT_TO_ARRIVE = "/NextToArrive";
    private static int NUM_RESULTS = 10;

    /**
     * Given the startStation and endStation, gets the next {@link #NUM_RESULTS} trip(s)
     *
     * @param startStation
     * @param endStation
     */
    public static void getNextToArrive(final RailTripInterface _interface, String startStation, String endStation) {
        String url = SEPTA_BASE_URL + NEXT_TO_ARRIVE + Constants.FORWARDSLASH + startStation +
                Constants.FORWARDSLASH + endStation + Constants.FORWARDSLASH + NUM_RESULTS;
        Log.d("URL", url);

        JsonArrayRequest objRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray jsonObject) {
                _interface.onTripReceivedSuccess(jsonObject);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                _interface.onTripReceivedError(error.getMessage());
            }
        }
        );

        RequestManager.getRequestQueue().add(objRequest);
    }
}
