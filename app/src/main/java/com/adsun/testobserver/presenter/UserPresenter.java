package com.adsun.testobserver.presenter;

import com.adsun.testobserver.callback.Callback;
import com.adsun.testobserver.contract.UserContract;
import com.adsun.testobserver.model.User;
import com.adsun.testobserver.utils.UserTask;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {
    UserContract.View mView;


    public UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> users) {
                mView.loadDataInList(users);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }

    @Override
    public void addUser(User user) {
        UserTask.addUser(user, new Callback<User>() {
            @Override
            public void returnResult(User user) {
                loadUsers();
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }
}
