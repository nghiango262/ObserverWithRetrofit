package com.adsun.testobserver.utils;

import com.adsun.testobserver.callback.Callback;
import com.adsun.testobserver.model.User;
import com.adsun.testobserver.networking.utils.NetworkingUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserTask {
    public static void addUser(User user, final Callback<User> callback) {

        NetworkingUtils.getUserApiInstance()
                .addUser("bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1ZDQyOWNmNmUyOTU2YjA3ZGM2ZGZmYjYiLCJpYXQiOjE1NjQ2NDg3NTMsImV4cCI6MTU2NDY1MjM1M30.mM52KiX5K51agM-j-ZvYYBppX-M6f6VgDwn0FQH3upI", user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        callback.returnResult(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void getUsers(final Callback<List<User>> callback) {
        NetworkingUtils.getUserApiInstance()

                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        callback.returnResult(users);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
