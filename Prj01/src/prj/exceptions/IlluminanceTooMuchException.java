package prj.exceptions;

public class IlluminanceTooMuchException extends Exception {

    public IlluminanceTooMuchException(String message, int l) {
        super(message);
        System.out.print("(можно добавить " + l + " лк" + ")");
    }
}
