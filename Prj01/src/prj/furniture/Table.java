package prj.furniture;

public class Table implements Furniture{

    private String name;
    private double square;

    public Table(String name, double square) {
        this.name = name;
        this.square = square;
    }

    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public void getDescription() {
        System.out.print(name + " " + square + " м2");
    }
}
