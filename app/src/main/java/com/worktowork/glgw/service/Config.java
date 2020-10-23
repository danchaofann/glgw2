package com.worktowork.glgw.service;

import com.blankj.utilcode.util.SPUtils;
import com.worktowork.glgw.util.MyUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2018/4/18.
 */
public class Config {
    public static boolean IS_DEBUG = true;

//    public static final String URL = "http://test.glgw.net.cn/sellerapi/";//测试服
    public static final String URL = "http://admin.glgw.net.cn/sellerapi/";//正式服
    public static final int CHOOSE_ADDRESS_REQUEST=10001; //选择银行卡请求码
    public static final int CHOOSE_ADDRESS_RESULT=10002; //选择银行卡返回

    static HttpLoggingInterceptor loggingInterceptor;
    private static SPUtils spUtils;

    public static HttpLoggingInterceptor getLoggingInterceptor() {
        if (null == loggingInterceptor) {
            loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    MyUtils.e("okhttp", message );
                }
            });
        }
        if (IS_DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return loggingInterceptor;
    }

    static Interceptor interceptor;

    public static Interceptor getInterceptor() {
//        if (null == interceptor) {
            interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request.Builder builder=chain.request().newBuilder();
                    return   chain.proceed(builder
                            .addHeader("userName", spUtils.getString("userName"))
                            .addHeader("adminToken", spUtils.getString("adminToken"))
                            .build());
                }
            };
//        }
        return interceptor;
    }

    static OkHttpClient client;

    public static OkHttpClient getClient() {
//        if (null == client) {
        spUtils = SPUtils.getInstance("token");
//        if (spUtils.getString("userName")==null){
            client = new OkHttpClient.Builder()
                    .addInterceptor(getLoggingInterceptor())
                    .build();
//        }else{
//            client = new OkHttpClient.Builder()
//                    .addInterceptor(getInterceptor())
//                    .addInterceptor(getLoggingInterceptor())
//                    .build();
//        }

//        }
        return client;
    }
}
