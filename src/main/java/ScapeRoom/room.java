package ScapeRoom;

import java.util.ArrayList;

public class room {

    private final int id;
    private int addId = 0;
    private String name;
    private lvls lvldiff;
    private double price;
    private ArrayList<clue> roomClues;
    private ArrayList<object> roomObject;

    public room(String name, double price) {
        this.id =+addId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public lvls getLvldiff() {
        return lvldiff;
    }

    public void setLvldiff(lvls lvldiff) {
        this.lvldiff = lvldiff;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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

    public static boolean duplicatedRoom(ArrayList<room> escapeRooms, String name) {
        for (room room : escapeRooms) {
            if (room.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Room: \n" +
                "\nID: " + id +
                "\nName: " + name +
                "\nLvl: " + lvldiff +
                "\nPrice: " + price +
                "\n Clues: " + roomClues +
                "\n Objects: " + roomObject;
    }
}
