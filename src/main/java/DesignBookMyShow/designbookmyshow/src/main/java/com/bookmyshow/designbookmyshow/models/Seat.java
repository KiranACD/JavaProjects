package com.bookmyshow.designbookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;
    @Column(name = "clmn")
    private int column;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
