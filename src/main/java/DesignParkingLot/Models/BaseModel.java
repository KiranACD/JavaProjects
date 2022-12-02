package DesignParkingLot.Models;

public abstract class BaseModel {
    private Long id;

    public Long getId() {
        return this.id;
    }

    public setId(Long id) {
        this.id = id;
    }
}