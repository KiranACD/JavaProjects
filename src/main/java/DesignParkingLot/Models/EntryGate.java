package DesignParkingLot.Models;

public class EntryGate extends Gate {
    private DisplayBoard displayBoard;

    public EntryGate(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }
}