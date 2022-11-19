package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Move;

public interface GameWinningStrategy {
    Boolean checkVictory(Board board, Move lastMove);
}