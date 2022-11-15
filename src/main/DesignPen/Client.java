
public class Client {
    
    public static void main(String[] args) {

        Ink ink = new Ink(Colour.BLUE);
        Nib nib = new Nib(0.2);
        Refill refill = new Refill(ink, nib, RefillType.BALL);

        WriteStrategy writestrategy = new SmoothWriteStrategy();
        BallPen reynolds = new BallPen(writestrategy, refill);
        reynolds.write();
        reynolds.describe();
    }
}