package com.spring;

public class UserValidationService {

    public boolean isValidUser(String user, String password){
        return user.equals("Tony") && password.equals("pass");
    }
}
