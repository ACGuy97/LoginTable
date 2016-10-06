package com.barranquero.logintable.controller;

/**
 * Class that implements the Login rules
 *  - At least one upper case and one lower case character
 *  - At least one digit
 *  - At least 8 characters long
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public class LoginTable_Controller implements ILoginMvc {

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
