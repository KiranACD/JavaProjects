package com.bookmyshow.designbookmyshow.exceptions;

public class ShowSeatNotAvailableException extends Exception{
    public ShowSeatNotAvailableException(Long seatId) {
        super("Seat: " + seatId + " is not available for booking.");
    }
}
