package com.bwie.store1505d.model;

/**
 * Created by liqy on 2017/8/8.
 */

public class RootData<T> {


    public int code;
    public boolean status;
    public String message;
    public T data;

    @Override
    public String toString() {
        return "RootData{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
