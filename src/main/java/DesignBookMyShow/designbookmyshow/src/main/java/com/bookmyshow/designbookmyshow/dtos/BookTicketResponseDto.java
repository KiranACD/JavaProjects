package com.bookmyshow.designbookmyshow.dtos;

import com.bookmyshow.designbookmyshow.models.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}
