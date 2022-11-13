package com.lafi.sljn.console;

import com.lafi.sljn.sample.loaders.SingleLoader;
import com.lafi.sljn.sample.models.Single;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
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
                                System.out.println(INVALID_OPTION);
                            }
                            break;
                        }
                    } while (!exitStartMenu);
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
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

        System.out.println(SELECT_OPTION);
    }

    private static void displayMainMenu() {
        System.out.println("+-----------+");
        System.out.println("| MAIN MENU |");
        System.out.println("|-----------|");
        System.out.println("| 0. Exit   |");
        System.out.println("| 1. Start  |");
        System.out.println("+-----------+");

        System.out.println(SELECT_OPTION);
    }

    static void displaySingles(Path path) {
        SingleLoader loader = new SingleLoader();

        List<Single> singles = loader.loadData(Paths.get(String.valueOf(path)));

        for (Single item : singles) {
            System.out.println(item);
        }
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
