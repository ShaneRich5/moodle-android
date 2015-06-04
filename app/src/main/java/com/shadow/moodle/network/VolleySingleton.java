package com.shadow.moodle.network;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.shadow.moodle.application.MoodleApplication;

/**
 * Created by Shane on 6/3/2015.
 */
public class VolleySingleton {
    private static String TAG = VolleySingleton.class.getSimpleName();
    private static VolleySingleton sInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    /**
     * Prevents multiple instances
     */
    private VolleySingleton() {

        mRequestQueue = Volley.newRequestQueue(MoodleApplication.getAppContext());

        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {

            private LruCache<String, Bitmap> cache = new LruCache<>((int) (Runtime.getRuntime().maxMemory()/1024)/8);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    /**
     *
     * @return instance of VolleySingleton
     */
    public static VolleySingleton getsInstance() {
        if (null == sInstance)
            sInstance = new VolleySingleton();
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
