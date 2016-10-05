package com.barranquero.logintable.controller;

import java.util.regex.Pattern;

/**
 * Controller class
 */
public class LoginTable_Controller {

    public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;

    public int validateCredentials(String user, String password) {
        if (!(password.matches("(.*)\\d(.*)")))
            return PASSWORD_DIGIT;
        if (!(password.matches("(.*)\\p{Lower}(.*)") && password.matches("(.*)\\p{Upper}(.*)")))
            return PASSWORD_CASE;
        if (password.length() < 8)
            return PASSWORD_LENGTH;
        else
            return OK;
    }
}
