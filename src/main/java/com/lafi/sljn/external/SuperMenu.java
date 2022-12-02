package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.SuperDatabase;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class SuperMenu {
    private static final SuperDatabase SUPERDB = SuperDatabase.getInstance();

    static void main() {
        boolean exitMenu = false;

        do {
            displayMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitMenu = true;
                }
                break;
                case 1: {
                    SuperMenu.readResource();
                }
                break;
                case 2: {
                    SuperMenu.readDatabase();
                }
                break;
                case 3: {
                    SuperMenu.readFrequencies();
                }
                break;
                case 4: {
                    SuperMenu.readDistances();
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitMenu);
    }

    private static void displayMenu() {
        System.out.println("+------------------------+");
        System.out.println("| SUPER MENU             |");
        System.out.println("|------------------------|");
        System.out.println("| 0. Exit menu           |");
        System.out.println("| 1. Load resource       |");
        System.out.println("| 2. Load database       |");
        System.out.println("| 3. Display frequencies |");
        System.out.println("| 4. Display distances   |");
        System.out.println("+------------------------+");

        System.out.println(SELECT_OPTION);
    }

    private static void readResource() {
        System.out.println(SUPER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(SUPER_PRINTING);
    }

    private static void readDatabase() {
        ConsoleMenu.displaySamples(SUPERDB.getSamples(), 40);

        System.out.println(SUPER_DATABASE);
    }

    private static void readFrequencies() {
        ConsoleMenu.displayFrequencies(SUPERDB.getAbsolutes(), SUPERDB.getRelatives(), 40);
    }

    private static void readDistances() {
        ConsoleMenu.displayDistances(SUPERDB.getIndexes(), SUPERDB.getPositives(), SUPERDB.getNegatives(), 40);
    }
}
