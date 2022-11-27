package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.JokerDatabase;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class JokerMenu {
    private static final JokerDatabase JOKERDB = JokerDatabase.getInstance();

    static void main() {

        boolean exitJokerMenu = false;
        do {
            displayMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitJokerMenu = true;
                }
                break;
                case 1: {
                    JokerMenu.readResource();
                }
                break;
                case 2: {
                    JokerMenu.readDatabase();
                }
                break;
                case 3: {
                    JokerMenu.readFrequencies();
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitJokerMenu);
    }

    private static void displayMenu() {
        System.out.println("+-------------------+");
        System.out.println("| JOKER MENU        |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit           |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. Load database  |");
        System.out.println("| 3. Frequencies    |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }

    private static void readResource() {
        System.out.println(JOKER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(JOKER_PRINTING);
    }

    private static void readDatabase() {
        ConsoleMenu.displaySamples(JOKERDB.getSamples(), 45);

        System.out.println(JOKER_DATABASE);
    }

    private static void readFrequencies() {
        ConsoleMenu.displayFrequencies(JOKERDB.getAbsolutes(), JOKERDB.getRelatives(), 45);
    }
}
