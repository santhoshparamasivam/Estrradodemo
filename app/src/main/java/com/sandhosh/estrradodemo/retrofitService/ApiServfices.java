package com.sandhosh.estrradodemo.retrofitService;


import com.sandhosh.estrradodemo.model.HomeResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServfices {

//    - https://estrradodemo.com/vinner/api/home
    @FormUrlEncoded
    @POST("vinner/api/home")
    Call<HomeResponseModel>homeMethod(@Field("access_token") String user, @Field("country_code") String country);
}
