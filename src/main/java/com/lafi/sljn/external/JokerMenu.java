package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.JokerDatabase;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class JokerMenu {
    private static final JokerDatabase JOKERDB = JokerDatabase.getInstance();

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
                    JokerMenu.readResource();
                }
                break;
                case 2: {
                    JokerMenu.readDatabase();
                }
                break;
                case 3: {
                    JokerMenu.readFrequencies();
                    JokerMenu.readSpecialFrequencies();
                }
                break;
                case 4: {
                    JokerMenu.readDistances();
                    JokerMenu.readSpecialDistances();
                }
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitMenu);
    }

    private static void displayMenu() {
        System.out.println("+------------------------+");
        System.out.println("| JOKER MENU             |");
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
        System.out.println(JOKER_LOADING);

        ConsoleMenu.displaySingles(JOKERDB.getSingles(), 45);

        System.out.println(JOKER_PRINTING);
    }

    private static void readDatabase() {
        ConsoleMenu.displaySamples(JOKERDB.getSamples(), 45);

        System.out.println(JOKER_DATABASE);
    }

    private static void readFrequencies() {
        ConsoleMenu.displayFrequencies(JOKERDB.getAbsolutes(), JOKERDB.getRelatives(), 45);
    }

    private static void readSpecialFrequencies() {
        ConsoleMenu.displayFrequencies(JOKERDB.getSpecialAbsolutes(), JOKERDB.getSpecialRelatives(), 20);
    }

    private static void readDistances() {
        ConsoleMenu.displayDistances(JOKERDB.getIndexes(), JOKERDB.getPositives(), JOKERDB.getNegatives(), 45);
    }

    private static void readSpecialDistances() {
        ConsoleMenu.displayDistances(JOKERDB.getSpecialIndexes(), JOKERDB.getSpecialPositives(), JOKERDB.getSpecialNegatives(), 20);
    }
}
