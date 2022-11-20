package com.lafi.sljn.external;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class JokerMenu {
    static void main() {

        boolean exitJokerMenu = false;
        do {
            displayJokerMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitJokerMenu = true;
                }
                break;
                case 1: {
                    JokerMenu.readJokerResource();
                }
                break;
                case 2: {
                    System.out.println("JOKER => option 2");
                }
                break;
                case 3: {
                    System.out.println("JOKER => option 3");
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitJokerMenu);
    }

    private static void readJokerResource() {
        System.out.println(JOKER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(JOKER_PRINTING);
    }

    private static void displayJokerMenu() {
        System.out.println("+-------------------+");
        System.out.println("| JOKER MENU        |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit Joker     |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. Load database  |");
        System.out.println("| 3. no name option |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }
}
