package com.linjie;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit){

            System.out.println("Welcome to Encode/Decoder software:\nPress 1 to encode\nPress 2 to decode\nPress Q to quit");
            String userChoice = scanner.next().toUpperCase();

            if (userChoice.equals("1")){
                displayInstruction("1");
            }
            else if (userChoice.equals("2")){
                displayInstruction("2");
            }
            else if (userChoice.equals("Q")){
                exit = true;
                System.out.println("Exiting software");
            }
            else{
                System.out.println("Please enter a valid input");
            }
        }

    }

    private static void displayInstruction(String choice){
        ReferenceTable referenceTable = new ReferenceTable();
        boolean acknowledgeMessage = false;
        Scanner messageScanner = new Scanner(System.in);

        System.out.println("Enter your message");
        String message = messageScanner.nextLine().toUpperCase();
        while (!acknowledgeMessage && !message.isEmpty()){
            System.out.println("The message is: ");
            System.out.println("==============================");
            if (choice.equals("1")){
                System.out.println(referenceTable.encode(message));
            }
            else {
                System.out.println(referenceTable.decode(message));
            }
            System.out.println("==============================");
            System.out.println("Press any keys and enter to acknowledge message");

            acknowledgeMessage = true;
        }
    }
}