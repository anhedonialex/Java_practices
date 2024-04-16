package com.example.p2_18;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("/materials/practical/get_info.php")
    Call<StudentInfoResponse> getStudentInfo(@Query("name")String n, @Query("group")String gr);

    @POST("/materials/practical/info.php")
    @FormUrlEncoded
    Call<StudentInfoResponse> getStudentInfoAll(@Field("name")String n, @Field("group")String gr);
}
