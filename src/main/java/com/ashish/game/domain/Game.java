package com.ashish.game.domain;

import javax.persistence.*;

@Entity
@Table
public class Game {

    @Id
    @GeneratedValue
    @Column
    private int roundId;

    @Column
    private String userName;

    @Column
    private  GameOption userOption;

    @Column
    private  GameOption applicationOption;

    @Column
    private  String winner;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public GameOption getUserOption() {
        return userOption;
    }

    public void setUserOption(GameOption userOption) {
        this.userOption = userOption;
    }

    public GameOption getApplicationOption() {
        return applicationOption;
    }

    public void setApplicationOption(GameOption applicationOption) {
        this.applicationOption = applicationOption;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
