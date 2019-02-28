package com.scy.component.login.logindata;

public class LoginUtil {
    private static String userName;

    public static void setUserName(String name){
        userName = name;
    }
    public static String getUserName(){
        return userName;
    }
}
