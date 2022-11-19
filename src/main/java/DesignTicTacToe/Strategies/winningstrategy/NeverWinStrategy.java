package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Move;

public class NeverWinStrategy implements GameWinningStrategy {

    public Boolean checkVictory(Board board, Move lastMove) {
        return false;
    }
}