package chencheng.bwie.com.yuekaolianxo.net;

import java.util.concurrent.TimeUnit;

import chencheng.bwie.com.yuekaolianxo.utils.LoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/1/8.
 */

public class RetrofitUtils {
    private static OkHttpClient client;
    private static ServerApi serverApi;
    static {
        getClient();
    }
    public static  OkHttpClient getClient(){
        /*final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/
        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        if (client==null){
            synchronized (RetrofitUtils.class){
                if (client == null) {
                    client=new OkHttpClient.Builder()
                            .addInterceptor(loggingInterceptor)
                            .connectTimeout(3000, TimeUnit.MILLISECONDS)
                            .build();

                }
            }

        }
        return client;
    }
    public static  ServerApi getServerApi(){
        if (serverApi==null){
            synchronized (OkHttpClient.class){
                if (serverApi==null){
                    serverApi=RetrofitUtils.onCreate(ServerApi.class,Api.HOME);
                }
            }
        }
        return  serverApi;
    }
    public  static <T> T onCreate(Class<T> tClass,String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        return  retrofit.create(tClass);

    }
}
