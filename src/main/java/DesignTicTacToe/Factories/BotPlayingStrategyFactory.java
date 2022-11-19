package DesignTicTacToe.Factories;

import DesignTicTacToe.Models.BotDifficultyLevel;
import DesignTicTacToe.Strategies.botplayingstrategy.BotPlayingStrategy;
import DesignTicTacToe.Strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficulty(BotDifficultyLevel botdifficultylevel) {
        return new RandomBotPlayingStrategy();
    }
}