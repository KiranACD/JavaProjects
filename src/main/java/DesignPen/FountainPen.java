
public class FountainPen extends Pen implements Refillable{

    private Ink ink;
    private Nib nib;

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Ink getInk() {
        return this.ink;
    }

    public void write() {}

    public void refill() {
        System.out.println("Refilling ink")
    }
    
}