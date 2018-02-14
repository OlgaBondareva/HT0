package prj.Main;

import java.util.LinkedList;

public class Building {
    private String name;
    private LinkedList <Room> rooms;

    public Building() {
        this.name = "Untitled Building";
        rooms = new LinkedList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void describe() {
        System.out.print("\n" + name);
        for (Room element: rooms) {
            element.describe();
        }
    }
}
