package DesignTicTacToe.Strategies;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Player;
import DesignTicTacToe.Models.Cell;
import DesignTicTacToe.Models.Move;
import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    public Move makeMove(Board board, Player player) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if (cell.getPlayer() == null) {
                    return new Move(cell.getRow(), cell.getColumn(), player);
                }
            }
        }
        return null;
    }
}