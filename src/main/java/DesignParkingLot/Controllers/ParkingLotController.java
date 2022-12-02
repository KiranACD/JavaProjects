package DesignParkingLot.Controllers;

import DesignParkingLot.Services.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();

    // public ParkingLotController(ParkingLotService parkingLotService) {
    //     this.parkingLotService = parkingLotService;
    // }

    public ResponseDto<CreateParkingLotResponseDto> createParkingLot(CreateParkingLotRequestDto request) {
        ParkingLot parkingLot = parkingLotService.createParkingLot(request.getAddress());
        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(parkingLot);

        ResponseDto<CreateParkingLotResponseDto> baseResponse = new ResponseDto<>();
        baseResponse.setStatus("Success");
        baseResponse.setData(response);
        return baseResponse;
    }
}
