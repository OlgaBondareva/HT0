package prj.Main;

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

    public Room(String n, double s, int wc) {
        this.name = n;
        this.square = s;
        this.windowCount = wc;
        illuminations = new LinkedList<>();
        furnitures = new LinkedList<>();
        this.luminosity = wc * Window.luminosity;
        for (int i = 0; i < wc; i++) {
            illuminations.add(new Window());
        }
    }

    public void addLightbulb(Lightbulb lightbulb) {
        luminosity += lightbulb.getLuminosity();
        illuminations.add(lightbulb);
    }

    public void addFurniture(Furniture furniture) {
        occupiedSquare += furniture.getSquare();
        furnitures.add(furniture);
    }

    public void describe() {
        System.out.print("\n\t" + name);
        System.out.print("\n\t\tОсвещённость = " + luminosity + " (");
        for (Illumination element: illuminations) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print(")");
        System.out.print("\n\t\tМебель: ");
        for (Furniture element: furnitures) {
            element.getDescription();
            System.out.print(", ");
        }
        System.out.print("\n\tЗанятая площадь: " + square + " м2");
        System.out.print(" (свободно " + occupiedSquare/square*100 + "%)");
    }
}
