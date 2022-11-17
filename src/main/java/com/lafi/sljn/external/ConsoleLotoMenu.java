package com.lafi.sljn.external;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class ConsoleLotoMenu {
    static void main() {

        boolean exitLotoMenu = false;
        do {
            displayLotoMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitLotoMenu = true;
                }
                break;
                case 1: {
                    ConsoleLotoMenu.readLotoResource();
                }
                break;
                case 2: {
                    System.out.println(LOTO_DATABASE);
                    ConsoleDatabaseMenu.main();
                }
                break;
                case 3: {
                    System.out.println("LOTO => option 3");
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitLotoMenu);
    }

    private static void readLotoResource() {
        System.out.println(LOTO_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(LOTO_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(LOTO_PRINTING);
    }

    private static void displayLotoMenu() {
        System.out.println("+-------------------+");
        System.out.println("| LOTO MENU         |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit Loto      |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. Load database  |");
        System.out.println("| 3. no name option |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }
}
