package DesignParkingLot.Models;

public abstract class Gate extends BaseModel {
    private int number;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;

    public GateStatus getGateStatus() {
        return this.gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public GateType getGateType() {
        return this.gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}