package com.adsun.testobserver.callback;

public interface Callback<T> {
    public void returnResult(T t);
    public void returnError(String message);
}
