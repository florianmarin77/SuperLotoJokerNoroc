package com.lafi.sljn.console;

import java.util.Scanner;

public class ConsoleMenu {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final boolean JOKER = false; // resource scenario


    public static void main(String[] args) {

        if (JOKER) {
            System.out.println("Welcome to Demo Module with numerical database resource!");
        } else {
            System.out.println("Welcome to Demo Module with alphabetical database resource!");
        }

        boolean exitMainMenu = false;
        do {
            displayMainMenu();
            int selectedChoice = SCANNER.nextInt();
            switch (selectedChoice) {
                case 0: {
                    exitMainMenu = true;
                }
                break;
                case 1: {
                    boolean exitSingleMenu = false;
                    do {
                        displaySingleMenu();
                        int selectedSingleOperation = SCANNER.nextInt();
                        switch (selectedSingleOperation) {
                            case 0: {
                                exitSingleMenu = true;
                                System.out.println("#0 MAIN MENU exit");
                            }
                            break;
                            case 1: {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("CREATE => Please enter DATA (text string): ");
                            }
                            break;
                            case 2: {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("READ => Please enter ID (integer number): ");
                            }
                            break;
                            case 3: {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("UPDATE => Please enter ID (integer number): ");
                            }
                            break;
                            case 4: {
                                Scanner scanner = new Scanner(System.in);
                                System.out.println("DELETE => Please enter ID (integer number): ");
                            }
                            break;
                            default: {
                                System.out.println("Please enter a valid operation!");
                            }
                            break;
                        }
                    } while (!exitSingleMenu);
                }
                break;
                default: {
                    System.out.println("Please make a valid choice!");
                }
                break;
            }
        } while (!exitMainMenu);
        System.out.println("Thank you!");
    }

    private static void displaySingleMenu() {
        System.out.println("SAMPLE MENU");
        System.out.println("---------");
        System.out.println("0. Main menu");
        System.out.println("1. Save single");
        System.out.println("2. Find single");
        System.out.println("3. Update single");
        System.out.println("4. Delete single");
        System.out.println("Select an option:");
    }

    private static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("---------");
        System.out.println("0. Exit");
        System.out.println("1. Singles");
        System.out.println("Make your choice:");
    }

}
