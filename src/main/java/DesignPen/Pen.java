public abstract class Pen {
    private WriteStrategy writeStrategy;
    private String name;
    private Cap cap;
    private String brand;
    private double length;

    public Pen(WriteStrategy writeStrategy) {
        this.writeStrategy = writeStrategy;
    }
    
    public void setWriteStrategy(WriteStrategy writeStrategy) {
        this.writeStrategy = writeStrategy;
    }

    public WriteStrategy getWriteStrategy() {
        return this.writeStrategy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCap(Cap cap) {
        this.cap = cap;
    }

    public Cap getCap() {
        return this.cap;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }
    public void write() {
        this.writeStrategy.write();
    }

}