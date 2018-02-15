package prj.exceptions;

public class SpaceUsageTooMuchException extends Exception {

    public SpaceUsageTooMuchException(String message, double s) {
        super(message);
        System.out.print("(свободно " + s + " м2" + ")");
    }
}
