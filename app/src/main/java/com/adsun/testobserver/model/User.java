package com.adsun.testobserver.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("_id")
    private String id;

    @SerializedName("firstName")
    private String title;

    @SerializedName("lastName")
    private String body;

    @SerializedName("username")
    private String userId;

    @SerializedName("password")
    private String pass;

    public User() {

    }

    public User(String usr, String pwd, String fName, String lName) {
        this.userId = usr;
        this.title = fName;
        this.body = lName;
        this.pass = pwd;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getBody(){
        return body;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    @Override
    public String toString(){
        return
                "User{" +
                        "id = '" + id + '\'' +
                        ",First name = '" + title + '\'' +
                        ",Last name = '" + body + '\'' +
                        ",username = '" + userId + '\'' +
                        "}";
    }
}
