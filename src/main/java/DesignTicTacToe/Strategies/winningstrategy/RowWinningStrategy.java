package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Move;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RowWinningStrategy implements GameWinningStrategy {

    private List<HashMap<Character, Integer>> rowCharCounts;

    public void initializeCount(Board board) {

        this.rowCharCounts = new ArrayList<>();

        int dim = board.getDimension();

        for (int i = 0; i < dim; ++i) {
            rowCharCounts.add(new HashMap<>());
        }
    }

    public Boolean checkVictory(Board board, Move lastMove) {

        if (this.rowCharCounts == null) {
            this.initializeCount(board);
        }

        int row = lastMove.getRow();
        //int col = lastMove.getColumn();

        Character character = lastMove.getPlayer().getSymbol().getCharacter();

        if (!rowCharCounts.get(row).containsKey(character)) {
            rowCharCounts.get(row).put(character, 0);
        }

        // if (!colCharCounts.get(col).containsKey(character)) {
        //     colCharCounts.get(col).put(character, 0);
        // }

        int rowCharVal = rowCharCounts.get(row).get(character);
        //int colCharVal = colCharCounts.get(col).get(character);

        rowCharCounts.get(row).put(character, 1+rowCharVal);
        //colCharCounts.get(col).put(character, 1+colCharVal);

        if (rowCharCounts.get(row).get(character).equals(board.getDimension())) {
            return true;
        }

        // if (colCharCounts.get(col).get(character).equals(board.getDimension())) {
        //     return true;
        // }

        return false;
    }
}