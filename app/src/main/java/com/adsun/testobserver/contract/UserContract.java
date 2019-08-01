package com.adsun.testobserver.contract;

import com.adsun.testobserver.model.User;

import java.util.List;

public interface UserContract {
    interface View {

        //Initial setup of recyclerview (adding layout manager).
        void init();

        //Creating an adapter from recyclerview using the list of users obtained from the API.
        void loadDataInList(List<User> users);

        //Showing some error message in case any error occurs.
        void showError(String message);


    }

    interface Presenter {

        //an initializer method for the presenter. You can perform all sorts of init tasks here such
        // as initializing some variables, calling a method of the view to show some init messages etc.
        // Here I’m using it to initialize the Recyclerview inside my UserActivity.java class.
        void start();

        //func is real task of the presenter is to get the data from the API and send it to the View
        //making our API call here and passing the result to view if successful else an error message.
        void loadUsers();

        void addUser(User user);
    }

}
