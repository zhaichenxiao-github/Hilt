package com.example.httplibrary.client;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogIncepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String method = request.method();
        HttpUrl url = request.url();
//        Logger.e("本次请求", "url:" + url.toString() + "=====method=====" + method);
//        Logger.e("本次json", "json" + request.toString());
        Logger.d("本次请求"+url.toString());
        Logger.e("本次请求:json"+request.toString());
        Headers headers = request.headers();
        Set<String> names = headers.names();
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String value = headers.get(next);
            Logger.e("=============:",next  + value);
        }
        return chain.proceed(request);
    }
}
