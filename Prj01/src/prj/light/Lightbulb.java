package prj.light;

public class Lightbulb implements Illumination{

    private final String name = "лампочка";
    private int luminosity;

    public Lightbulb(int luminosity) {
        this.luminosity = luminosity;
    }

    @Override
    public int getLuminosity() {
        return luminosity;
    }

    @Override
    public void getDescription() {
        System.out.print(name + " " + luminosity + " лк");
    }
}
