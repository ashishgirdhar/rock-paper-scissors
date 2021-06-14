package com.ashish.game.exception;


/**
 * Exception to raise when an operation was launched for a non-existing user
 */
public class InvalidGameOptionException extends Exception {

    private String gameOption;

    public String getGameOption() {
        return gameOption;
    }

    public void setUserName(String gameOption) {
        this.gameOption = gameOption;
    }

    public InvalidGameOptionException(String gameOption) {
        super();
        this.gameOption  = gameOption;
    }
}
