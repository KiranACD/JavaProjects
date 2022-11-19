package DesignTicTacToe.Factories;

import DesignTicTacToe.Models.GameWinningStrategyName;
import DesignTicTacToe.Exceptions.WinningStrategyException;

public class GameWinningStrategyNameEnumFactory {

    public static GameWinningStrategyName getGameWinningStrategyEnumByName(String name) {
        
        if (name.equals("ROW")) {
            return GameWinningStrategyName.ROW;
        } else if (name.equals("COLUMN")) {
            return GameWinningStrategyName.COLUMN;
        } else if (name.equals("CORNER")) {
            return GameWinningStrategyName.CORNER;
        } else if (name.equals("DIAGONAL")) {
            return GameWinningStrategyName.DIAGONAL;
        } else {
            throw new WinningStrategyException(name);
        }
    }
}