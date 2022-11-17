package DesignTicTacToe.Factories;

public class GameWinningStrategyNameEnumFactory {

    public static GameWinningStrategyName getGameWinningStrategyEnumByName(String name) {
        
        if (name.equals("ROW")) {
            return GameWinningStrategyName.ROW;
        } else if (name.equals("Column")) {
            return GameWinningStrategyName.COLUMN;
        } else if (name.equals("CORNER")) {
            return GameWinningStrategyName.CORNER;
        } else if (name.equals("DIAGONAL")) {
            return GameWinningStrategyName.DIAGONAL;
        } else {
            throw new exception();
        }
    }
}