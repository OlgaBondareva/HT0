package prj.light;

public class Lightbulb implements Illuminationable{

    private int luminosity;
    private final String name = "лампочка";

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
