
public class Pigeon extends Bird implements Flyable, Dancer {

    FlyBehaviour fb;

    public Pigeon(String pname, String pcolour, Double pweight, int page, FlyBehaviour pfb) {
        this.name = pname;
        this.weight = pweight;
        this.colour = pcolour;
        this.age = page;

        this.fb = pfb;
    }

    public void fly() {
        this.fb.makeFly();
    }

    public void eat() {
        System.out.println("Pigeon " + this.name + " is eating.");
    }

    public void dance() {
        System.out.println("Pigeon " + this.name + " is dancing.");
    }
}