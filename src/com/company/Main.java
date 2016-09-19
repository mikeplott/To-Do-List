package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Item>> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.println("Please enter your username");
            String name = scanner.nextLine();

            ArrayList<Item> items = users.get(name);
            if (items == null) {
                items = new ArrayList<>();
                users.put(name, items);
            }
            boolean isLoggedIn = true;
            while (isLoggedIn) {
                System.out.println();
                System.out.println("1: Create to-do item");
                System.out.println("2: Toggle to-do item");
                System.out.println("3: List all to-do items");
                System.out.println("4: Logout");
                System.out.println();

                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.println();
                        System.out.println("Enter your to-do item:");
                        String text = scanner.nextLine();
                        Item item = new Item(text, false);
                        items.add(item);
                        break;
                    case "2":
                        System.out.println();
                        System.out.println("Which item do you want to toggle?");
                        int i = Integer.valueOf(scanner.nextLine());
                        Item item2 = items.get(i -1);
                        item2.isDone = !item2.isDone;
                        break;
                    case "3":
                        System.out.println();
    //                    for (Item item3 : items) {
    //                        System.out.println(item3.text);
    //                    }
                        for (int j = 0; j < items.size(); j++ ) {
                            Item item3 = items.get(j);
                            int num = j +1;
                            String checkbox = "[ ]";
                            if (item3.isDone) {
                                checkbox = "[x]";
                            }
                            System.out.println(checkbox + " " + num + ":" + " " + item3.text);
                        }
                        break;
                    case "4" :
                        isLoggedIn = false;
                        //main(args);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
