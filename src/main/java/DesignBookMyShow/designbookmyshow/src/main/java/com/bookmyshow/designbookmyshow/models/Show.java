package com.bookmyshow.designbookmyshow.models;


import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
    
    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Screen screen;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}
