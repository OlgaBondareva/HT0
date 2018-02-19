package prj.base;

import prj.exceptions.RoomNullPointerException;

import java.util.LinkedList;

public class Building {
    private String name;
    private LinkedList<Room> rooms;

    public Building() {
        this.name = "Untitled Building";
        rooms = new LinkedList<>();
    }

    public Building(String name) {
        this.name = name;
        rooms = new LinkedList<>();
    }

    public Building(String name, LinkedList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void describe() {
        System.out.print("\n" + name);
        for (Room element : rooms) {
            element.describe();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom(String roomName) throws RoomNullPointerException{
        for (Room element : rooms) {
            if (element.getName().equals(roomName)) {
                return element;
            }
        }
        throw new RoomNullPointerException("Such room don't exist in this building!");
    }
}
