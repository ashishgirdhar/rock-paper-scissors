package com.ashish.game.domain;



import javax.persistence.*;

public class Stats {

    private String userName;

    private int totalGames;
    private int winGames;
    private int loseGames;

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getWinGames() {
        return winGames;
    }

    public void setWinGames(int winGames) {
        this.winGames = winGames;
    }

    public int getLoseGames() {
        return loseGames;
    }

    public void setLoseGames(int loseGames) {
        this.loseGames = loseGames;
    }

    public int getDrawGames() {
        return drawGames;
    }

    public void setDrawGames(int drawGames) {
        this.drawGames = drawGames;
    }

    private int drawGames;

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
}
