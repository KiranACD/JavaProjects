package DesignTicTacToe.Factories;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botdifficultylevel) {
        return new RandomBotPlayingStrategy();
    }
}