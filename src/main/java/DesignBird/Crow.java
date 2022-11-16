
public class Crow extends Bird implements Flyable, Dancer {

    Flyable fb;

    public Crow(String cname, String ccolour, Double cweight, int cage) {
        this.name = cname;
        this.weight = cweight;
        this.colour = ccolour;
        this.age = cage;
    }

    public void fly() {
        System.out.println("Crow " + this.name + " is flying.");
    }

    public void eat() {
        System.out.println("Crow " + this.name + " is eating.");
    }

    public void dance() {
        System.out.println("Crow " + this.name + " is dancing.");
    }
}