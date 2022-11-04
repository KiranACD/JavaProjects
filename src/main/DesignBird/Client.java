
public class Client {

    public static void main(String[] args) {
        FlyBehaviour psfb = new PigeonSparrowFlyBehaviour();
        Pigeon p = new Pigeon("Carl", "Grey", 1.5, 2, psfb);
        p.fly();
        p.eat();
        p.dance();

        Crow c = new Crow("Ramesh", "Black", 1.0, 5);
        c.fly();
        c.eat();
        c.dance();
    }
}