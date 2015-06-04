package com.shadow.moodle.json;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.JsonObjectRequest;
import com.shadow.moodle.logger.Logger;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Shane on 6/3/2015.
 */
public class Requestor {
    public static JSONObject getRequestJSON(RequestQueue requestQueue, String url) {
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();
        JSONObject response = null;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, requestFuture, requestFuture);
        requestQueue.add(request);

        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Logger.m(e + "");
        } catch (ExecutionException e) {
            Logger.m(e + "");
        } catch (TimeoutException e) {
            Logger.m(e + "");
        }
        return response;
    }
}
