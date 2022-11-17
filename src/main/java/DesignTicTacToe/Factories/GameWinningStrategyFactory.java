package DesignTicTacToe.Factories;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGameWinningStrategyByName(GameWinningStrategyName gameWinningStrategyName) {
        return switch (gameWinningStrategyName) {
            case COLUMN -> new OrderOneWinningStrategy();
            case ROW -> new OrderOneWinningStrategy();
            case CORNER -> new NeverWinStrategy();
            case DIAGONAL -> null;
        };
    }
}