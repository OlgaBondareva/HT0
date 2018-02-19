package prj.light;

public class Window extends Illumination{

    private final String name = "окно";
    public final static int luminosity = 700;

    @Override
    public void getDescription() {
        System.out.print(name + " " + luminosity + " лк");
    }
}
