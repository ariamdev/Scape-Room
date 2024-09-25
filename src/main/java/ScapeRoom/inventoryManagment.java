package ScapeRoom;

import java.util.ArrayList;

public class inventoryManagment  {
    private ArrayList<room> escapeRooms;
    private ArrayList<clue> roomClues;
    private ArrayList<object> roomObject;

    public ArrayList<clue> getRoomClues() {
           return roomClues;
    }

    public void setRoomClues(ArrayList<clue> roomClues) {
        this.roomClues = roomClues;
    }

    public ArrayList<object> getRoomObject() {
        return roomObject;
    }

    public void setRoomObject(ArrayList<object> roomObject) {
        this.roomObject = roomObject;
    }

    public ArrayList<room> getEscapeRooms() {
        return escapeRooms;
    }

    public void setEscapeRooms(ArrayList<room> escapeRooms) {
        this.escapeRooms = escapeRooms;
    }

    public void emptyEscapeRooms(ArrayList<room> escapeRooms) throws exceptionRoom {
        if (escapeRooms.isEmpty()) {
            throw new exceptionRoom("Create a new room first.");
        }
    }

    @Override
    public String toString() {
        return "Inventory Managment:\n " +
                "Escape Rooms: " + escapeRooms +
                "\n Clues: " + roomClues +
                "\n Objects: " + roomObject;
    }
}
