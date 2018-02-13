package prj.furniture;

public class Chair implements Furniture{

    private double square;

    @Override
    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
