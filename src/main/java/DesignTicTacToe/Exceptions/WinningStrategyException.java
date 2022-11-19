package DesignTicTacToe.Exceptions;

public class WinningStrategyException extends RuntimeException {

    public WinningStrategyException(String winningStrategyName) {
        System.out.println("Winning strategy " + winningStrategyName + " is not implemented!");
    }
}