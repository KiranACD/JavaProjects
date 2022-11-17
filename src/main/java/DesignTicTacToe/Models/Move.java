package DesignTicTacToe.Models;

public class Move {
    private int row;
    private int column;
    private Player player;

    public Move(int row, int column, Player player) {
        this.row = row;
        this.column = column;
        this.player = player;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }
}