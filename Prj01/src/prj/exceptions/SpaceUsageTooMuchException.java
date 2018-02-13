package prj.exceptions;

public class SpaceUsageTooMuchException extends Exception {
    private double square;

    public SpaceUsageTooMuchException(String message, double s) {
        super(message);
        square = s;
    }
}
