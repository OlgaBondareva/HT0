package prj.furniture;

public class Table extends Furniture{

    public Table(String name, double square) {
        super(name, square);
    }
    public void getDescription() {
        System.out.print(name + " " + square + " м2");
    }
}
