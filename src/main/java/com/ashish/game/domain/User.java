package com.ashish.game.domain;



import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column
    private  int userId;

    @Column
    private String userName;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
