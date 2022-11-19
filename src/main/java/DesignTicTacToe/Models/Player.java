package DesignTicTacToe.Models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private PlayerType playerType;
    private String name;

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What row (starting from 0)?");
        Integer row = scanner.nextInt();

        System.out.println("What column (starting from 0)?");
        Integer column = scanner.nextInt();

        Move move = new Move(row, column, this);

        return move;
    }
}