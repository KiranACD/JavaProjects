package DesignTicTacToe.Models;

import DesignTicTacToe.Strategies.botplayingstrategy.BotPlayingStrategy;
import DesignTicTacToe.Factories.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botdifficultylevel;
    private BotPlayingStrategy botplayingstrategy;

    public Bot(BotDifficultyLevel botdifficultylevel) {
        this.botdifficultylevel = botdifficultylevel;
        this.botplayingstrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficulty(this.botdifficultylevel);
    }

    public Move makeMove(Board board) {
        Move move = this.botplayingstrategy.makeMove(board, this);
        return move;
    }
}