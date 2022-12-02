package com.bookmyshow.designbookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.designbookmyshow.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Ticket save(Ticket ticket);
}
