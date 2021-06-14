package com.ashish.game.exception;


/**
 * Exception to raise when an operation was launched for a non-existing user
 */
public class UserNotExistException extends Exception {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserNotExistException(String userName) {
        super();
        this.userName  = userName;
    }
}
