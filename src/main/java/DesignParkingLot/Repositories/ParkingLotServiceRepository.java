package DesignParkingLot.Repositories;

public class ParkingLotRepository {
    private static List<ParkingLot> parkingLots;
    private static long nextId = 0;
    public ParkingLot static save(ParkingLot parkingLot) {
        parkingLot.setId(this.nextId);
        ParkingLotRepository.nextId += 1;
        ParkingLotRepository.parkingLots.add(parkingLot);

        return parkingLot;
    }
}
