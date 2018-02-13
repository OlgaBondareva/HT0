package prj.light;

public class Lightbulb implements Illumination{

    private int luminosity;

    @Override
    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }
}
