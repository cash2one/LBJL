package com.example.terry.lbjl.http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Terry on 2016/9/26.
 */
public class HttpUtils {
    public static void getDataFromNetWork(String path){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(path).get().build();
        client.newCall(request);
    }
}
