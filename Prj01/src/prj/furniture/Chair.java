package prj.furniture;

public class Chair extends Furniture {

    public Chair(String name, double square) {
        super(name, square);
    }

    public void getDescription() {
        System.out.print(name + " " + square + " м2");
    }
}
