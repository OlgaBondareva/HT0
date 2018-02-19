package prj.light;

public class Lightbulb extends Illumination{

    private final String name = "лампочка";

    public Lightbulb(int luminosity) {
        this.luminosity = luminosity;
    }

    @Override
    public void getDescription() {
        System.out.print(name + " " + luminosity + " лк");
    }
}
