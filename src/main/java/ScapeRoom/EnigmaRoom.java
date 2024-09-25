package ScapeRoom;

import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class EnigmaRoom {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<room> escapeRooms = new ArrayList<>();
    static ArrayList<clue> roomClues = new ArrayList<>();
    static ArrayList<object> roomObject = new ArrayList<>();
    static inventoryManagment inventory = new inventoryManagment();

    public static void startProgram() throws exceptionRoom {
        int opt = 0;

        do {
            System.out.println("MENÚ: \n" +
                    "1. Create new Scape Room.\n" +
                    "2. Add a clue to Scape Room.\n" +
                    "3. Add objects to Scape Room.\n" +
                    "4. Show inventory. \n" +
                    "5. Remove elements of the inventory. \n" +
                    "0. Log out. ");
            opt = readInt();
            switch (opt){
                case 1: createRoom();
                    break;
                case 2: createClue();
                    break;
                case 3: createObject();
                    break;
                case 4: fullInventory(); //To finish
                    break;
                case 5: //to create.
                    break;
                default: System.out.println("Please, choose between the options.");
            }
        }while (opt != 0); {
            System.out.println("Bye bye!");
        }
    }

    public static void createRoom() throws exceptionRoom {

        System.out.println("Write the name of the room: ");
        String name = readString();
        System.out.println("Set a price for the scape room: ");
        double price = readDouble();

        room scape1 = new room(name,price);

        System.out.println("Choose the difficulty lvl: \n" +
                "1.EASY \n" +
                "2.MEDIUM\n" +
                "3.DIFFICULT\n ");
        int lvl = readInt();

        try {
            switch (lvl) {
                case 1:
                    scape1.setLvldiff(lvls.EASY);
                    break;
                case 2:
                    scape1.setLvldiff(lvls.MEDIUM);
                    break;
                case 3:
                    scape1.setLvldiff(lvls.DIFFICULT);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("You must choose between the three options.");
        }

        if (room.duplicatedRoom(escapeRooms,name)) {
            System.err.println("There's a room with the same name. Try again.");
        } else {
            escapeRooms.add(scape1);

            inventory.emptyEscapeRooms(escapeRooms);
            inventory.setEscapeRooms(escapeRooms);
            System.out.println("You have create the scape room " + name + " successfully.");
        }

    }

    public static double readDouble(){
        double valorDouble = 0d;
        boolean valid = false;

        do {
            try {
                valorDouble = sc.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.err.println("You must write a valid price with a point (.) not coma.");
                sc.nextLine();
            }
        }while (!valid);
        return valorDouble;
    }

    public static int readInt(){
        int valueInt = 0;
        boolean valid = false;

        do {
            try {
                valueInt = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.err.println("Please, choose between the options with a number.");
                sc.nextLine();
            }
        } while (!valid);
        return valueInt;
    }


    public static String readString(){
        String stringValue = "";
        boolean valid = false;

        do {
            try {
                stringValue = sc.next();
                valid = true;
            } catch (Exception e) {
                System.err.println("Please, write a valid word. ");
                sc.nextLine();
            }
        }while (!valid);
        return stringValue;
    }

    public static void createClue(){

        System.out.println("Write a name for the clue: ");
        String name = readString();
        System.out.println("Set the theme for the clue: ");
        String theme = readString();
        System.out.println("Set a time to solve the clue: ");
        double time = readDouble();
        System.out.println("Set a price of the clue: ");
        double price = readDouble();
        clue cl1 = new clue(name,price,time,theme);
        roomClues.add(cl1);

        System.out.println("Write the name of the room that you want to add the clues: ");
        String nameRoom = readString();

        try {
            escapeRooms.stream()
                    .filter(room -> room.getName().equalsIgnoreCase(nameRoom))
                    .findFirst()
                    .ifPresent(room -> room.setRoomClues(roomClues));
            inventory.setRoomClues(roomClues);
            System.out.println("The clue has created correctly.");
        } catch (Exception e){
            System.out.println("There aren't a room with this name. Please create one.");
        }

    }

    public static void createObject(){

        System.out.println("Write a name for the object: ");
        String name = readString();
        System.out.println("Set the description for the object: ");
        String description = readString();
        System.out.println("Set the material of the object: ");
        String material = readString();
        System.out.println("Set a price of the object: ");
        double price = readDouble();
        object obj1 = new object(name,description,material,price);
        roomObject.add(obj1);

        System.out.println("Write the name of the room that you want to add the object: ");
        String nameRoom = readString();

        try {
            escapeRooms.stream()
                    .filter(room -> room.getName().equalsIgnoreCase(nameRoom))
                    .findFirst()
                    .ifPresent(room -> room.setRoomObject(roomObject));
            inventory.setRoomObject(roomObject);
            System.out.println("The object has created correctly.");
        } catch (Exception e){
            System.out.println("There aren't a room with this name. Please create one.");
        }

    }

    public static double totalPriceRoom (){
        double totalPriceRoom = 0;
        for(room totalRooms : escapeRooms){
            totalPriceRoom += totalRooms.getPrice();
        }
        return  totalPriceRoom;
    }
    public static double totalPriceObj (){
        double totalPriceObj = 0;
        for (object totalobjects : roomObject) {
            totalPriceObj += totalobjects.getPrice();
        }
        return totalPriceObj;
    }

    public static double totalPriceClue(){
        double totalPriceClues= 0;
        for(clue totalClue : roomClues){
            totalPriceClues += totalClue.getPrice();
        }
        return totalPriceClues;
    }

    public static String totalPrice (){
        double priceRooms = totalPriceRoom();
        double priceObjects = totalPriceObj();
        double priceClues = totalPriceClue();

        double totalPrice = priceRooms + priceObjects + priceClues;

        return "The total price of the inventory is: " + totalPrice;
    }

    public static void fullInventory() throws NullPointerException {
       try {
           System.out.println("Scape rooms: ");
           inventory.getEscapeRooms().forEach(System.out::println);

       }catch (NullPointerException e){
           System.out.println("Unable to find a room in the inventory. Try again.");
       }

       try{
           System.out.println("Objects: ");
           inventory.getRoomObject().forEach(System.out::println);
       }catch (NullPointerException e){
            System.out.println("Unable to find all the objects of the inventory. Try again.");
        }

       try{
           System.out.println("Clues: ");
           inventory.getRoomClues().forEach(System.out::println);
       }catch (NullPointerException e){
           System.out.println("Unable to find all the clues of the inventory. Try again.");
       }

       totalPrice();
}

}

