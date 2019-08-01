package com.adsun.testobserver.networking.API;

import com.adsun.testobserver.model.User;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserService {

    @GET("/v1/user")
    Observable<List<User>> getUsers();

    @POST("/v1/user/register")
    Observable<User> addUser(@Header("Authorization") String authorization,
                               @Body User user
    );
}
