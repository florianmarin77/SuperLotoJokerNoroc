package com.lafi.sljn.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.lafi.sljn.sample.messages.CommonMessages.*;

public class ConsoleMenu {
    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exitMainMenu = false;
        do {
            displayMainMenu();

            int selectedChoice = selectValidOption();

            switch (selectedChoice) {
                case 0: {
                    exitMainMenu = true;
                }
                break;
                case 1: {
                    boolean exitStartMenu = false;
                    do {
                        displayStartMenu();

                        int selectedSystem = selectValidOption();

                        switch (selectedSystem) {
                            case 0: {
                                exitStartMenu = true;
                            }
                            break;
                            case 1: {
                                ConsoleSuperMenu.main();
                            }
                            break;
                            case 2: {
                                ConsoleLotoMenu.main();
                            }
                            break;
                            case 3: {
                                ConsoleJokerMenu.main();
                            }
                            break;
                            default: {
                                System.out.println(INVALID_SYSTEM);
                            }
                            break;
                        }
                    } while (!exitStartMenu);
                }
                break;
                default: {
                    System.out.println(INVALID_CHOICE);
                }
                break;
            }
        } while (!exitMainMenu);
        System.out.println("Thank you!");
    }

    private static void displayStartMenu() {
        System.out.println("+---------------+");
        System.out.println("|  START  MENU  |");
        System.out.println("|---------------|");
        System.out.println("| 0. Main menu  |");
        System.out.println("| 1. Super 5/40 |");
        System.out.println("| 2. Loto 6/49  |");
        System.out.println("| 3. Joker 5/45 |");
        System.out.println("+---------------+");
        System.out.println("Please select an option:");
    }

    private static void displayMainMenu() {
        System.out.println("+-----------+");
        System.out.println("| MAIN MENU |");
        System.out.println("|-----------|");
        System.out.println("| 0. Exit   |");
        System.out.println("| 1. Start  |");
        System.out.println("+-----------+");
        System.out.println("Please make your choice:");
    }

    static int selectValidOption() {
        int selectedOption;

        while (true) {
            try {
                selectedOption = SCANNER.nextInt();
                break;
            } catch (InputMismatchException exception) {
                System.out.println(INVALID_NUMBER);
            }
            SCANNER.nextLine();
        }

        return selectedOption;
    }
}
