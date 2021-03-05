//Aditya Bhandari
// Take out program project
//I abide by GTCC's academic integrity program
//this is my own original work



package com.company;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int typeOfFood = 0;
        int feeds = 0;
        double price = 0d;
        double taxRate = 0.7d;
        double tipRate = 0.15d;


        System.out.println("Welcome");
        System.out.println("How many people are ordering the food?");
        Scanner inputScanner = new Scanner(System.in);
        //Takes in the input for the number of people
        int people = inputScanner.nextInt();
        if (people < 10)
        {
            System.exit(0);
        }
        //Displaying menu with input validation here
        do {
            displayMainMenu();
        }
        while (typeOfFood > 3);
        typeOfFood = inputScanner.nextInt();
        //after we know what type of food they want we branch here
        switch (typeOfFood) {
            case 1 -> displayItalianFoodMenu();
            case 2 -> displayChineseFoodMenu();
            case 3 -> displayAmericanFoodMenu();
            default -> System.out.println("Please enter a valid number");
        }

        //switch statement to determine price and feeds
        if (typeOfFood == 1) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> feeds = 5;
                case 2 -> feeds = 7;
                case 3 -> feeds = 4;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
            switch (choice){
                case 1 -> price = 17.99;
                case 2 -> price = 15.99;
                case 3 -> price = 12.99;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
        else if (typeOfFood == 2)
        {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1, 2 -> feeds = 7;
                case 3 -> feeds = 5;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
            switch (choice){
                case 1, 2 -> price = 18.99;
                case 3 -> price = 10.99;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
        else if (typeOfFood == 3)
        {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> feeds = 8;
                case 2 -> feeds = 5;
                case 3 -> feeds = 10;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }

            switch (choice){
                case 1 -> price = 21.99;
                case 2 -> price = 22.99;
                case 3 -> price = 26.99;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }

        }




         //returns integer how many trays
         int trays = determineTrays(people,feeds);


         double subTotal = getSubtotal(price, trays);

         double taxPrice = getTax(subTotal,taxRate);

         double tip = getTip(subTotal, tipRate);


         double grandTotal = getGrandTotal(subTotal,taxPrice, tip);

         double pricePerPerson = pricePerPerson(grandTotal, people);


         int leftOver = determineLeftOvers(feeds, trays, people);

         displayTotal(trays,feeds,people,taxPrice,grandTotal,pricePerPerson,leftOver,subTotal);



    }


    //This function will display the main menu for the user
    public static void displayMainMenu(){
        System.out.println("CHOSE TYPE OF MEAL");
        System.out.println("____________");
        System.out.println("1.Italian");
        System.out.println("2.Chinese");
        System.out.println("3.American");
        System.out.println("Choose what type of food you'd like to order ( 1 - 3 ): ");
    }

    public static void displayItalianFoodMenu(){
        System.out.println("CHOOSE ONE");
        System.out.println("_________");
        System.out.println("1. Lasagna Tray - Feeds 5 - 17.99");
        System.out.println("2. Pizza Pack - Feeds 7 - 15.99");
        System.out.println("3. Gazpacho Soup, salad and bread sticks pack - Feeds 4 - 12.99");
        System.out.println("Enter Choice ( 1 - 3 )");
    }


    public static void displayChineseFoodMenu(){
        System.out.println("CHOOSE ONE");
        System.out.println("_________");
        System.out.println("1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - 18.99");
        System.out.println("2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - 18.99");
        System.out.println("3. Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - 10.99");
        System.out.println("Enter Choice ( 1 - 3 )");
    }

    public static void displayAmericanFoodMenu(){
        System.out.println("CHOOSE ONE");
        System.out.println("_________");
        System.out.println("1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - 21.99");
        System.out.println("2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 -\n" +
                "22.99");
        System.out.println("3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - 26.99");
        System.out.println("Enter Choice ( 1 - 3 )");
    }


    public static int determineTrays(int people, int feeds)
    {
        int numberOfTrays= people / feeds;
        if (people % feeds != 0){
            numberOfTrays++;
        }

        return numberOfTrays;
    }

    public static double getSubtotal(double price, int trays){
        double subTotal = 0;
        subTotal = price * trays;

        return subTotal;
    }

    public static double getTax(double subtotal, double taxRate)
    {
        double tax = subtotal * taxRate;

        return tax;
    }

    public static double getTip(double subtotal, double tipRate)
    {
        double tip = subtotal * tipRate;
        return  tip;

    }

    public static double getGrandTotal(double subtotal, double tax, double tip)
    {
        double total = subtotal + tax + tip;
        return total;
    }

    public static double pricePerPerson(double grandTotal, int people)
    {
        double pricePerPerson = grandTotal / people;
        return pricePerPerson;
    }

    public static int determineLeftOvers(int feeds, int trays, int people)
    {
        int leftOvers = people - (feeds * trays);
        return leftOvers;
    }

    public static void displayTotal(int trays, int feeds, int people, double taxPrice, double grandTotal, double pricePerPerson, int leftOver, double subTotal)
    {
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("You need " + trays + " trays");
        System.out.println("Feeds: "+ feeds);
        System.out.println("Price for " + people + " people (" + trays + " trays ):" + formatter.format(subTotal) );
        System.out.println("Tax:" + formatter.format(taxPrice));
        System.out.println("Total ( food , tax , tip ): " + formatter.format(grandTotal));
        System.out.println("Price per person :" + formatter.format(pricePerPerson));
        System.out.println("Leftover servings for the delivery person :" + leftOver);
    }


}
