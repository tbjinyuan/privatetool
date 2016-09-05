package com.zk.toolbox.dao.domain;

import java.io.Serializable;

/**
 * Created by zhengke on 16/9/4.
 */
public class User implements Serializable {


    private int uid;

    private String data;

    private String userName;

    private int     age;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override public String toString() {
        return "User{" + "uid=" + uid + ", data='" + data + '\'' + ", userName='" + userName + '\'' + '}';
    }



}
