package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.LotoDatabase;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class LotoMenu {
    private static final LotoDatabase LOTODB = LotoDatabase.getInstance();

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
                case 4: {
                    LotoMenu.readDistances();
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
        System.out.println("| LOTO MENU              |");
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
        System.out.println(LOTO_LOADING);

        ConsoleMenu.displaySingles(LOTODB.getSingles(), 49);

        System.out.println(LOTO_PRINTING);
    }

    private static void readDatabase() {
        ConsoleMenu.displaySamples(LOTODB.getSamples(), 49);

        System.out.println(LOTO_DATABASE);
    }

    private static void readFrequencies() {
        ConsoleMenu.displayFrequencies(LOTODB.getAbsolutes(), LOTODB.getRelatives(), 49);
    }

    private static void readDistances() {
        ConsoleMenu.displayDistances(LOTODB.getIndexes(), LOTODB.getPositives(), LOTODB.getNegatives(), 49);
    }
}
