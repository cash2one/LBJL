package com.example.terry.lbjl.http;

import android.os.Handler;

import com.example.terry.lbjl.callback.DataCallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Terry on 2016/9/26.
 */
public class HttpUtils {

    private static HttpUtils httpUtils;
//    DataCallBack dataCallBack;
    Handler handler = new Handler();

    public static HttpUtils getHttpUtils() {
       if (httpUtils == null) {
            httpUtils = new HttpUtils();
      }
        return httpUtils;
    }

//    public void setDataCallBack(DataCallBack dataCallBack) {
//        this.dataCallBack = dataCallBack;
//    }

    public void getDataFromNetWork(String path,final DataCallBack dataCallBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        Call call = client.newCall(request);
        if (call.isExecuted()) {
            call.cancel();
        } else {
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    final String data = response.body().string();
                    if (dataCallBack != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                dataCallBack.setDataCallBack(data);
                            }
                        });
                    }
                }
            });
        }
    }
}
