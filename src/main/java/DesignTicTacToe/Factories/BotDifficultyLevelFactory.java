package DesignTicTacToe.Factories;

import DesignTicTacToe.Models.BotDifficultyLevel;

public class BotDifficultyLevelFactory {
    
    public static BotDifficultyLevel getBotDifficultyLevelByName(String difficultylevel) {

        if (difficultylevel.equals("EASY")) {
            return BotDifficultyLevel.EASY;
        } else if (difficultylevel.equals("MEDIUM")) {
            return BotDifficultyLevel.MEDIUM;
        } else {
            return BotDifficultyLevel.HARD;
        }
    }
}