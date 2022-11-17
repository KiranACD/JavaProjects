package DesignTicTacToe.Factories;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficulty(BotDifficultyLevel botdifficultylevel) {
        return new RandomBotPlayingStrategy();
    }
}