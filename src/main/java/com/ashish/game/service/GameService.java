package com.ashish.game.service;


import com.ashish.game.domain.*;
import com.ashish.game.engine.RuleEngine;
import com.ashish.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameService {

    public static final String APPLICATION = "APPLICATION";
    public static final String DRAW = "DRAW";

   @Autowired
    private GameRepository gameRepository;


    public Game play(User user, String gameOption) {
        GameOption applicationOption = RuleEngine.getApplicationMove();
        GameOption userOption = GameOption.valueOf(gameOption.toUpperCase());
        Result winner = RuleEngine.winner(userOption,applicationOption);
        Game game = new Game();
        game.setUserName(user.getUserName());
        game.setUserOption(userOption);
        game.setApplicationOption(applicationOption);
        game.setWinner(getWinnerName(winner,user));
        return gameRepository.save(game);
    }

    public Game play(User user) {
        GameOption applicationOption = RuleEngine.getApplicationMove();
        GameOption userOption = RuleEngine.getMove();
        Result winner = RuleEngine.winner(userOption,applicationOption);
        Game game = new Game();
        game.setUserName(user.getUserName());
        game.setUserOption(userOption);
        game.setApplicationOption(applicationOption);
        game.setWinner(getWinnerName(winner,user));
        return gameRepository.save(game);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public String getWinnerName(Result winner, User user){
        if(winner.equals(Result.WINNER_PLAYER)){
            return user.getUserName();
        } else if(winner.equals(Result.WINNER_APPLICATION)){
            return APPLICATION;
        }
        return DRAW;
    }

    public  Stats findStats(String userName) {
        List<Game> userGames = getUserGames(userName);
        List<Game> winnerGames = userGames
                .stream()
                .filter(c -> c.getWinner().equalsIgnoreCase(userName))
                .collect(Collectors.toList());
        List<Game> drawGames = userGames
                .stream()
                .filter(c -> c.getWinner().equalsIgnoreCase(DRAW))
                .collect(Collectors.toList());
        Stats stats = new Stats();
        stats.setUserName(userName);
        stats.setTotalGames(userGames.size());
        stats.setWinGames(winnerGames.size());
        stats.setDrawGames(drawGames.size());
        stats.setLoseGames(userGames.size() - winnerGames.size() - drawGames.size() );
        return stats;


        //retur
        // n gameRepository.findAll();
    }

    public List<Game> getUserGames(String userName){
        List<Game> games =  gameRepository.findAll();
        List<Game> userGames = games
                .stream()
                .filter(c -> c.getUserName().equalsIgnoreCase(userName))
                .collect(Collectors.toList());
        return userGames;
    }



}
