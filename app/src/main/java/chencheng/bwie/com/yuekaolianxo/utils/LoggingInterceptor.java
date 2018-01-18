package chencheng.bwie.com.yuekaolianxo.utils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 自定义拦截器
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //GET自定义拦截器
        if (request.method().equals("GET")) {
            HttpUrl url = request.url().newBuilder()
                    .addQueryParameter("source", "android")
                    .build();
            //添加请求头
            Request newrequest = request.newBuilder()
                    .url(url)
                    .build();
            return chain.proceed(newrequest);
        }else {
            //POST自定义拦截器
            String url = request.url().url().toString();
            url+="&source=android";
            Request newRequset = request.newBuilder().url(url).build();
            return chain.proceed(newRequset);
        }
    }
}