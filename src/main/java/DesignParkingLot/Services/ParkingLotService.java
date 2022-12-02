package DesignParkingLot.Services;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot createParkingLot(String address) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(address);
        ParkingLot savedParkingLot = ParkingLotRepository.save(parkingLot);
        return savedParkingLot;
    }
}