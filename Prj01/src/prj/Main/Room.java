package prj.Main;

import prj.exceptions.IlluminanceTooFewException;
import prj.exceptions.IlluminanceTooMuchException;
import prj.exceptions.SpaceUsageTooMuchException;
import prj.furniture.Furniture;
import prj.light.Illumination;
import prj.light.Lightbulb;
import prj.light.Window;

import java.util.LinkedList;

public class Room {
    private String name;
    private int windowCount;
    private double square;
    private double occupiedSquare;
    private int luminosity;
    private LinkedList<Illumination> illuminations;
    private LinkedList<Furniture> furnitures;

    public Room(String n, double s, int wc) throws IlluminanceTooFewException {
        this.name = n;
        this.square = s;
        this.windowCount = wc;
        illuminations = new LinkedList<>();
        furnitures = new LinkedList<>();
        this.luminosity = wc * Window.luminosity;
        for (int i = 0; i < wc; i++) {
            illuminations.add(new Window());
        }
        if (luminosity < 300)
            throw new IlluminanceTooFewException("Площадь помещения освещена менее, чем на 300 лк", (300 - luminosity));
    }

    public void addLightbulb(Lightbulb lightbulb) throws IlluminanceTooMuchException {
        int temp = luminosity + lightbulb.getLuminosity();
        if (temp > 4000) throw new IlluminanceTooMuchException("Освещённость больше 4000 лк.", (4000 - luminosity));
        luminosity += lightbulb.getLuminosity();
        illuminations.add(lightbulb);
    }

    public void addFurniture(Furniture furniture) throws SpaceUsageTooMuchException {
        double percent = (occupiedSquare + furniture.getSquare()) / square;
        if (percent > 0.7)
            throw new SpaceUsageTooMuchException("Площадь комнаты " + name + "занята больше, чем на 70%", (square - occupiedSquare));
        occupiedSquare += furniture.getSquare();
        furnitures.add(furniture);
    }

    public void describe() {
        System.out.print("\n\t" + name);
        System.out.print("\n\t\tОсвещённость = " + luminosity + " (");
        for (Illumination element : illuminations) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print(")");
        System.out.print("\n\t\tМебель: ");
        for (Furniture element : furnitures) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print("\n\tЗанятая площадь: " + square + " м2");
        System.out.print(" (свободно " + occupiedSquare / square * 100 + "%)");
    }
}
