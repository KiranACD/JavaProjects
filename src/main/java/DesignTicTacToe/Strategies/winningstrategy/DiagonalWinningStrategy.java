package DesignTicTacToe.Strategies.winningstrategy;

import DesignTicTacToe.Models.Board;
import DesignTicTacToe.Models.Move;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DiagonalWinningStrategy implements GameWinningStrategy {

    private List<HashMap<Character, Integer>> diagonalCharCounts;
    // private List<HashMap<Character, Integer>> colCharCounts;

    public void initializeCount(Board board) {

        this.diagonalCharCounts = new ArrayList<>();
        //this.colCharCounts = new ArrayList<>();

        for (int i = 0; i < 2; ++i) {
            this.diagonalCharCounts.add(new HashMap<>());
            //colCharCounts.add(new HashMap<>());
        }
    }

    public Boolean checkVictory(Board board, Move lastMove) {

        if (this.diagonalCharCounts == null) {
            this.initializeCount(board);
        }

        int row = lastMove.getRow();
        int col = lastMove.getColumn();
        int dim = board.getDimension();

        Character character = lastMove.getPlayer().getSymbol().getCharacter();

        if (row == col) {
            if (!this.diagonalCharCounts.get(0).containsKey(character)) {
                this.diagonalCharCounts.get(0).put(character, 0);
        }

            int diagonalCharVal = this.diagonalCharCounts.get(0).get(character);
            this.diagonalCharCounts.get(0).put(character, 1+diagonalCharVal);

            if (this.diagonalCharCounts.get(0).get(character).equals(dim)) {
                return true;
            }
        
        }

        if (row+col == dim-1) {
            if (!this.diagonalCharCounts.get(1).containsKey(character)) {
                this.diagonalCharCounts.get(1).put(character, 0);
            }

            int diagonalCharVal = this.diagonalCharCounts.get(1).get(character);
            this.diagonalCharCounts.get(1).put(character, 1+diagonalCharVal);

            if (this.diagonalCharCounts.get(1).get(character).equals(dim)) {
                return true;
            }
        }

        return false;

        // if (!colCharCounts.get(col).containsKey(character)) {
        //     colCharCounts.get(col).put(character, 0);
        // }
    }
}