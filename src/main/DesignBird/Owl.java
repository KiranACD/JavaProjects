
public class Owl extends Bird implements Flyable, Dancer {

    Flyable fb;

    public Owl(String oname, String ocolour, Double oweight, int oage) {
        this.name = oname;
        this.weight = oweight;
        this.colour = ocolour;
        this.age = oage;
    }

    public void fly() {
        System.out.println("Owl " + this.name + " is flying.");
    }

    public void eat() {
        System.out.println("Owl " + this.name + " is eating.");
    }

    public void dance() {
        System.out.println("Owl " + this.name + " is dancing.");
    }
}