package prj.base;

import prj.exceptions.IlluminanceTooFewException;
import prj.exceptions.IlluminanceTooMuchException;
import prj.exceptions.SpaceUsageTooMuchException;
import prj.furniture.Furniture;
import prj.light.Illuminationable;
import prj.light.Lightbulb;
import prj.light.Window;

import java.util.LinkedList;

public class Room {
    private String name;
    private int windowCount;
    private double square;
    private double occupiedSquare;
    private int luminosity;
    private LinkedList<Illuminationable> illuminations;
    private LinkedList<Furniture> furnitures;

    /**
     * @param name        room's name
     * @param square      room's square
     * @param windowCount window's count in this room
     * @throws IlluminanceTooFewException
     */
    public Room(String name, double square, int windowCount) throws IlluminanceTooFewException, IlluminanceTooMuchException {
        this.name = name;
        this.square = square;
        this.windowCount = windowCount;
        illuminations = new LinkedList<>();
        furnitures = new LinkedList<>();
        if ((windowCount * Window.luminosity) > 4000)
            throw new IlluminanceTooMuchException("Площадь помещения освещена более, чем на 4000 лк", (4000 - windowCount * Window.luminosity));
        this.luminosity = windowCount * Window.luminosity;
        for (int i = 0; i < windowCount; i++) {
            illuminations.add(new Window());
        }
        if (luminosity < 300)
            throw new IlluminanceTooFewException("Площадь помещения освещена менее, чем на 300 лк", (300 - luminosity));
    }

    /**
     * @param lightbulb
     * @throws IlluminanceTooMuchException
     */
    public void add(Lightbulb lightbulb) throws IlluminanceTooMuchException {
        int temp = luminosity + lightbulb.getLuminosity();
        if (temp > 4000) throw new IlluminanceTooMuchException("Освещённость больше 4000 лк.", (4000 - luminosity));
        luminosity += lightbulb.getLuminosity();
        illuminations.add(lightbulb);
    }

    public void add(Furniture furniture) throws SpaceUsageTooMuchException {
        double percent = (occupiedSquare + furniture.getSquare()) / square;
        if (percent > 0.7)
            throw new SpaceUsageTooMuchException("Площадь комнаты " + name + "занята больше, чем на 70%", (square - occupiedSquare));
        occupiedSquare += furniture.getSquare();
        furnitures.add(furniture);
    }

    public void describe() {
        System.out.print("\n\t" + name);
        System.out.print("\n\t\tОсвещённость = " + luminosity + " лк" + " (");
        for (Illuminationable element : illuminations) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print(")");
        System.out.print("\n\t\tМебель: ");
        for (Furniture element : furnitures) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print("\n\t\tВся площадь: " + square + " м2");
        System.out.print("\n\t\tЗанятая площадь: " + occupiedSquare + " м2");
        System.out.print(" (свободно " + (100 - (occupiedSquare / square * 100)) + "%)");
    }

    public String getName() {
        return name;
    }
}
