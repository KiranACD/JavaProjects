package com.bookmyshow.designbookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.designbookmyshow.exceptions.ShowSeatNotAvailableException;
import com.bookmyshow.designbookmyshow.models.ShowSeat;
import com.bookmyshow.designbookmyshow.models.ShowSeatState;
import com.bookmyshow.designbookmyshow.models.Ticket;
import com.bookmyshow.designbookmyshow.models.TicketStatus;
import com.bookmyshow.designbookmyshow.models.User;
import com.bookmyshow.designbookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.designbookmyshow.repositories.TicketRepository;
import com.bookmyshow.designbookmyshow.repositories.UserRepository;

@Service
public class TicketService {

    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository,
                         UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }
    
    public Ticket bookTicket(List<Long> showSeatIds, Long userId, Long showId) throws ShowSeatNotAvailableException {

        // 1. Fetch show seats from the database.
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);
        // 2. Check status of those show seats.
        // 3. If any of them is not in AVAILABLE state, throw exception.
        for (ShowSeat showSeat: showSeats) {
            if (!showSeat.getShowSeatState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }
        
        // 4. Take a lock

        // 5. Again check if all are availble. 
        for (ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }
        // 6. If yes, create a new object of ticker and store in db.
        Ticket ticket = new Ticket();

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {

        }

        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setShowSeats(showSeats);
        return ticketRepository.save(ticket);
    }
}
