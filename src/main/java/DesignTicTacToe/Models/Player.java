package DesignTicTacToe.Models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private PlayerType playertype;
    private String name;

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public PlayerType getPlayertype() {
        return this.playertype;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What row (starting from 0)?")
        Integer row = scanner.nextInt();

        System.out.println("What column (starting from 0)?")
        Integer column = scanner.nextInt();

        Move move = new Move(row, column, this);

        return move;
    }
}