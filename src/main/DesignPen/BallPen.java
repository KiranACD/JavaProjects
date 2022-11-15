
public class BallPen extends Pen{

    private Refill refill;

    public BallPen(WriteStrategy writeStrategy) {
        super(writeStrategy);
    }
    public Refill getRefill() {
        return this.refill;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
    }
    public void write() {
        this.writeStrategy.write();
    }

}