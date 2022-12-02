package com.bookmyshow.designbookmyshow.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.bookmyshow.designbookmyshow.models.ShowSeat;
import com.bookmyshow.designbookmyshow.models.ShowSeatState;

import jakarta.persistence.LockModeType;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    // map with id as key and object as value
    // This is an interface because Spring automatically creates the queries for you.

    @Lock(LockModeType.PESSIMISTIC_WRITE) // This is SELECT * FOR UPDATE query
    List<ShowSeat> findAllByIdIn(Iterable<Long> ids);

    ShowSeat save(ShowSeat showSeat);
}
