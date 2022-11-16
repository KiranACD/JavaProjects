public class Refill {

    private Ink ink;
    private Nib nib;
    private RefillType refilltype;

    public Refill(Ink ink, Nib nib, RefillType refilltype) {
        this.ink = ink;
        this.nib = nib;
        this.refilltype = refilltype;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Ink getInk() {
        return this.ink;
    }

    public void setNib(Nib nib) {
        this.nib = nib;
    }

    public Nib getNib() {
        return this.nib;
    }

    public void setRefilltype(RefillType r) {
        this.refilltype = r;
    }

    public RefillType getRefilltype() {
        return this.refilltype;
    }
}