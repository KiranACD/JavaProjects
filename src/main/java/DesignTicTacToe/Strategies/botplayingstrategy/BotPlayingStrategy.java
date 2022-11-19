package DesignTicTacToe.Strategies.botplayingstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Player;
import DesignTicTacToe.Models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}