package com.ashish.game.engine;

import com.ashish.game.domain.GameOption;
import com.ashish.game.domain.Result;

import java.util.Random;

public class RuleEngine {

        public static Result winner(GameOption playerOption, GameOption applicationOption) {
            if (playerOption == applicationOption) {
                return Result.DRAW;
            }
            if (playerOption == GameOption.ROCK && applicationOption == GameOption.SCISSORS) {
                return Result.WINNER_PLAYER;
            }
            if (playerOption == GameOption.PAPER && applicationOption == GameOption.ROCK) {
                return Result.WINNER_PLAYER;
            }
            if (playerOption == GameOption.SCISSORS && applicationOption == GameOption.PAPER) {
                return Result.WINNER_PLAYER;
            }
            return Result.WINNER_APPLICATION;
        }

        public static GameOption getApplicationMove()
        {
            GameOption applicationOption;
            Random random = new Random();
            int input = random.nextInt(3)+1;
            if (input == 1)
                applicationOption = GameOption.ROCK;
            else if(input == 2)
                applicationOption = GameOption.PAPER;
            else
                applicationOption = GameOption.SCISSORS;

            return applicationOption;
        }

        public static GameOption getMove(){
            return getApplicationMove();
        }


}
