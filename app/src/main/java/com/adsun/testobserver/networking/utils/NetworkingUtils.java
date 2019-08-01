package com.adsun.testobserver.networking.utils;

import com.adsun.testobserver.networking.API.UserService;
import com.adsun.testobserver.networking.adapter.RetrofitAdapter;

public class NetworkingUtils {
    private static UserService userService;

    public static UserService getUserApiInstance() {
        if (userService == null)
            userService = RetrofitAdapter.getInstance().create(UserService.class);

        return userService;
    }
}
