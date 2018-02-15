package prj.exceptions;

public class IlluminanceTooFewException extends Exception {
    public IlluminanceTooFewException(String message, int l) {
        super(message);
        System.out.print("(нужно добавить " + l + " лк" + ")");
    }
}
