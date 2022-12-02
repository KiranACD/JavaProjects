package com.bookmyshow.designbookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen extends BaseModel{

    private String name;
    
    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features; // This was ManyToMany. The enum is element collection. We can store as STRING or ORDINAL.
    // It is an element collection because it is a list of features.
}
