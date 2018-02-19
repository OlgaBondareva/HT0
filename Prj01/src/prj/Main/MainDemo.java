package prj.Main;

import prj.base.Building;
import prj.base.Room;
import prj.exceptions.IlluminanceTooFewException;
import prj.exceptions.IlluminanceTooMuchException;
import prj.exceptions.SpaceUsageTooMuchException;
import prj.furniture.Chair;
import prj.furniture.Table;
import prj.light.Lightbulb;

public class MainDemo {

    public static void main(String[] args) throws IlluminanceTooFewException, IlluminanceTooMuchException, SpaceUsageTooMuchException {
        Building building1 = new Building();
        building1.addRoom(new Room("Room1", 100, 3));
        building1.addRoom(new Room("Room2", 5, 2));
        building1.getRoom("Room1").add(new Lightbulb(150));
        building1.getRoom("Room1").add(new Lightbulb(250));
        building1.getRoom("Room1").add(new Table("Desk", 3));
        building1.getRoom("Room1").add(new Chair("Soft and fluffy chair", 2));
        building1.describe();

    }
}
