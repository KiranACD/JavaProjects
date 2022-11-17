package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;
import java.utils.List;
import java.utils.HashMap;

public class OrderOneWinningStrategy implements WinningStrategy {

    private List<HashMap<Character, Integer>> rowCharCounts;
    private List<HashMap<Character, Integer>> colCharCounts;

    public void initializeCount(Board board) {

        this.rowCharCounts = new ArrayList<>();
        this.colCharCounts = new ArrayList<>();

        int dim = board.getDimension();

        for (int i = 0; i < dim; ++i) {
            rowCharCounts.add(new HashMap<>());
            colCharCounts.add(new HashMap<>());
        }
    }

    public Boolean checkVictory(Board board, Move lastMove) {

        if (this.rowCharCounts == null) {
            this.initializeCount(board);
        }

        int row = lastMove.getRow();
        int col = lastMove.getColumn();

        Character character = lastMove.getPlayer().getSymbol().getCharacter();

        if (!rowCharCounts.get(row).containsKey(character)) {
            rowCharCounts.get(row).put(character, 0);
        }

        if (!colCharCounts.get(col).containsKey(character)) {
            colCharCounts.get(col).put(character, 0);
        }

        int rowCharVal = rowCharCounts.get(row).get(character);
        int colCharVal = rowCharCounts.get(col).get(character);

        rowCharCounts.get(row).put(character, 1+rowCharVal);
        colCharCounts.get(col).put(character, 1+colCharVal);

        if (rowCharCounts.get(row).get(character).equals(board.getDimension())) {
            return true;
        }

        if (colCharCounts.get(col).get(character).equals(board.getDimension())) {
            return true;
        }

        return false;
    }
}