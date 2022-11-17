package DesignTicTacToe.Models;


public class Bot extends Player{
    private BotDifficultyLevel botdifficultylevel;
    private BotPlayingStrategy botplayingstrategy;

    public Bot(BotDifficultyLevel botdifficultylevel) {
        this.botdifficultylevel = botdifficultylevel;
        this.botplayingstrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficulty(this.botdifficultylevel);
    }

    public Move makeMove(Board board) {
        this.botplayingstrategy.makeMove(board, this);
    }
}