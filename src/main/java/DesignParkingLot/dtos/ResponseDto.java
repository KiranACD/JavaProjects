package DesignParkingLot.dtos;

public class ResponseDto<T> {
    private String status;
    private T data;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}