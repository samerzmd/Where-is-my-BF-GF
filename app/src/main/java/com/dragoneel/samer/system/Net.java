package com.dragoneel.samer.system;

import android.database.Observable;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by LocalAdmin on 1/2/2016.
 */
public class Net {
    public interface MyService {
        @GET("/MAPS/saveloc.php")
        Call<Object> saveLocation(@Query("name") String name, @Query("lon") String lon, @Query ("lat") String lat);
    }
    static void SaveLocation(String name,String lon,String lat){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient();
// add your other interceptors …
// add logging as last interceptor
        httpClient.interceptors().add(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://79.134.150.46")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        MyService service = retrofit.create(MyService.class);

        Call<Object> wtf= service.saveLocation(name,lon,lat);
       wtf.enqueue(new Callback<Object>() {
           @Override
           public void onResponse(retrofit.Response<Object> response, Retrofit retrofit) {
               response.body();
           }

           @Override
           public void onFailure(Throwable t) {
                t.toString();
           }
       });
    }
}
