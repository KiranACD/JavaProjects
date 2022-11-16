package DesignTicTacToe.Models;

import java.utils.ArrayList;
import java.utils.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Cell getCell(int row, int col) {
        return this.board.get(row).get(col);
    }

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();

        for (int i = 0; i < dimension; ++i) {
            this.board.add(new ArrayList<>());

            for (int j = 0; j < dimension; ++j) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public List<List<Cell>> getBoard() {
        return this.board;
    }

    public void display() {
        for (List<Cell> row: this.board) {
            for (Cell cell: row) {
                if (cell.getPlayer() == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + cell.getPlayer().getSymbol().getCharacter() + " ");
                }
            }
            System.out.println();
        }
    }    
}