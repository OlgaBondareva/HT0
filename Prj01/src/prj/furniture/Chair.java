package prj.furniture;

public class Chair implements Furniture {

    private String name;
    private double square;

    public Chair(String name, double square) {
        this.name = name;
        this.square = square;
    }

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public void getDescription() {
        System.out.print(name + " " + square + " м2");
    }
}
