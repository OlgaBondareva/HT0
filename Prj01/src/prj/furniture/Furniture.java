package prj.furniture;

public class Furniture {
    protected String name;
    protected double square;

    public Furniture(String name, double square) {
        this.name = name;
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void getDescription() {
    }
}
