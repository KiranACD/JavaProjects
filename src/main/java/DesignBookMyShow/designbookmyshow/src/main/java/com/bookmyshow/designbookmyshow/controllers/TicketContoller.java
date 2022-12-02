package com.bookmyshow.designbookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookmyshow.designbookmyshow.dtos.BookTicketRequestDto;
import com.bookmyshow.designbookmyshow.dtos.BookTicketResponseDto;
import com.bookmyshow.designbookmyshow.exceptions.ShowSeatNotAvailableException;
import com.bookmyshow.designbookmyshow.services.TicketService;

@Controller
public class TicketContoller {
    private TicketService ticketService;

    @Autowired
    public TicketContoller(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) throws ShowSeatNotAvailableException {
        ticketService.bookTicket(request.getShowSeatIds(), request.getUserId(), request.getShowId());
        return null;
    }
}
