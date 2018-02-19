package prj.light;

public class Window implements Illuminationable{

    private final String name = "окно";
    public final static int luminosity = 700;

    @Override
    public int getLuminosity() {
        return luminosity;
    }

    @Override
    public void getDescription() {
        System.out.print(name + " " + luminosity + " лк");
    }
}
