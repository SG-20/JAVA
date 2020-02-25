package com.sg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player sg = new Player("SG", 10, 15);
        System.out.println(sg.toString());
        saveObject(sg);

        sg.setHitPoints(8);
        System.out.println(sg);
        sg.setWeapon("Needle");
        saveObject(sg);
        //loadObejct(sg);
        System.out.println(sg);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);
       // System.out.println("Strength = " + ((Monster) werewolf).getStrength());

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;

        System.out.println("===========================\n" + "Choose \n" + "1 - to enter a string\n" + "0 - to quit\n" +
                "===========================");

        while (!quit) {
            System.out.println("Choose a option:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObejct(ISaveable obejctToLoad) {
        ArrayList<String> values = readValues();
        obejctToLoad.read(values);
    }


}
