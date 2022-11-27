package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.LotoDatabase;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class LotoMenu {
    private static final LotoDatabase LOTODB = LotoDatabase.getInstance();

    static void main() {

        boolean exitLotoMenu = false;
        do {
            displayMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitLotoMenu = true;
                }
                break;
                case 1: {
                    LotoMenu.readResource();
                }
                break;
                case 2: {
                    LotoMenu.readDatabase();
                }
                break;
                case 3: {
                    LotoMenu.readFrequencies();
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitLotoMenu);
    }

    private static void displayMenu() {
        System.out.println("+-------------------+");
        System.out.println("| LOTO MENU         |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit           |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. Load database  |");
        System.out.println("| 3. Frequencies    |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }

    private static void readResource() {
        System.out.println(LOTO_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(LOTO_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(LOTO_PRINTING);
    }

    private static void readDatabase() {
        ConsoleMenu.displaySamples(LOTODB.getSamples(), 49);

        System.out.println(LOTO_DATABASE);
    }

    private static void readFrequencies() {
        ConsoleMenu.displayFrequencies(LOTODB.getAbsolutes(), LOTODB.getRelatives(), 49);
    }
}
