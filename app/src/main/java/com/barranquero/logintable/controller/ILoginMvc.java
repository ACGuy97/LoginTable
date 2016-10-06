package com.barranquero.logintable.controller;

/**
 * Interface that has the structure for the Controller classes
 * @author José Antonio Barranquero Fernández
 * @version 1.0
 */
public interface ILoginMvc {
    int validateCredentials(String user, String password);
}
