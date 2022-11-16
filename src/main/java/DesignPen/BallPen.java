
public class BallPen extends Pen{

    private Refill refill;

    public BallPen(WriteStrategy writeStrategy, Refill refill) {
        super(writeStrategy);
        this.refill = refill;
    }

    public Refill getRefill() {
        return this.refill;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
    }

    public void write() {super.write();}

    public void describe() {
        Colour c = this.refill.getInk().getColour();
        System.out.println(c);
    }

}