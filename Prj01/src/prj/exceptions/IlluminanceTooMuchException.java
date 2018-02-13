package prj.exceptions;

public class IlluminanceTooMuchException extends Exception {
    private int luminosity;

    public int getluminosity() {
        return luminosity;
    }

    public IlluminanceTooMuchException(String message, int l) {
        super(message);
        luminosity = l;
    }
}
