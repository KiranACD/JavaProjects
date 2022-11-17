package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;

public interface WinningStrategy {
    Boolean checkVictory(Board board);
}