package DesignTicTacToe.Factories;

import DesignTicTacToe.Strategies.winningstrategy.GameWinningStrategy;
import DesignTicTacToe.Models.GameWinningStrategyName;
import DesignTicTacToe.Strategies.winningstrategy.OrderOneWinningStrategy;
import DesignTicTacToe.Strategies.winningstrategy.NeverWinStrategy;
import DesignTicTacToe.Strategies.winningstrategy.ColWinningStrategy;
import DesignTicTacToe.Strategies.winningstrategy.RowWinningStrategy;
import DesignTicTacToe.Strategies.winningstrategy.DiagonalWinningStrategy;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGameWinningStrategyByName(GameWinningStrategyName gameWinningStrategyName) {
        return switch (gameWinningStrategyName) {
            case COLUMN -> new ColWinningStrategy();
            case ROW -> new RowWinningStrategy();
            case CORNER -> new NeverWinStrategy();
            case DIAGONAL -> new DiagonalWinningStrategy();
        };
    }
}