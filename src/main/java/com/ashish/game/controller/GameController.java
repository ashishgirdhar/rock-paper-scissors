package com.ashish.game.controller;

import com.ashish.game.domain.Game;
import com.ashish.game.domain.GameOption;
import com.ashish.game.domain.Stats;
import com.ashish.game.domain.User;
import com.ashish.game.exception.InvalidGameOptionException;
import com.ashish.game.exception.UserNotExistException;
import com.ashish.game.service.GameService;
import com.ashish.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/user/{userName}/play",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Game playRandomly(@PathVariable final String  userName) throws UserNotExistException {
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UserNotExistException(userName);
        }
        return gameService.play(user);
    }

    @GetMapping(value = "/user/{userName}/play/{gameOption}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Game playWithUserOption(@PathVariable final String  userName,@PathVariable final String  gameOption) throws UserNotExistException, InvalidGameOptionException {
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UserNotExistException(userName);
        }
        if(GameOption.valueOf(gameOption) == null){
            throw new InvalidGameOptionException(gameOption);
        }
        return gameService.play(user,gameOption);
    }

    @GetMapping(value = "/all")
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/stats/user/{userName}")
    public  Stats findStats(@PathVariable final String  userName) {
        return gameService.findStats(userName);
    }
}
