
public class Sparrow extends Bird implements Flyable, Dancer {

    Flyable fb;

    public Sparrow(String sname, String scolour, Double sweight, int sage, Flyable sfb) {
        this.name = sname;
        this.weight = sweight;
        this.colour = scolour;
        this.age = sage;

        this.fb = sfb;
    }

    public void fly() {
        this.fb.makeFly();
    }

    public void eat() {
        System.out.println("Sparrow " + this.name + " is eating.");
    }

    public void dance() {
        System.out.println("Sparrow " + this.name + " is dancing.");
    }
}