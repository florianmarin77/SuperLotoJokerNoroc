package com.lafi.sljn.external;

import static com.lafi.sljn.internal.message.CommonMessages.INVALID_OPTION;
import static com.lafi.sljn.internal.message.CommonMessages.SELECT_OPTION;

public class ConsoleDatabaseMenu {
    static void main() {

        boolean exitDatabaseMenu = false;
        do {
            displayDatabaseMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitDatabaseMenu = true;
                }
                break;
                case 1: {
                    System.out.println("CREATE => option 1");
                }
                break;
                case 2: {
                    System.out.println("READ => option 2");
                }
                break;
                case 3: {
                    System.out.println("UPDATE => option 3");
                }
                break;
                case 4: {
                    System.out.println("DELETE => option 4");
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitDatabaseMenu);
    }

    private static void displayDatabaseMenu() {
        System.out.println("+------------------+");
        System.out.println("| DATABASE MENU    |");
        System.out.println("|------------------|");
        System.out.println("| 0. Exit Database |");
        System.out.println("| 1. Create Sample |");
        System.out.println("| 2. Read Sample   |");
        System.out.println("| 3. Update Sample |");
        System.out.println("| 4. Delete Sample |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }

}
