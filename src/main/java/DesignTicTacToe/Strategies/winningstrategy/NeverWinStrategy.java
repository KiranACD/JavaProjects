package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;

public class NeverWinStrategy implements WinningStrategy {

    public Boolean checkVictory(Board board, Move lastMove) {
        return false;
    }
}