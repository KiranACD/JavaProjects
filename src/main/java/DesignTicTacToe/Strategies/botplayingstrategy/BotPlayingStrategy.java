package DesignTicTacToe.Strategies.botplayingstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}