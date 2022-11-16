package com.lafi.sljn.external;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class ConsoleSuperMenu {
    static void main() {

        boolean exitSuperMenu = false;
        do {
            displaySuperMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitSuperMenu = true;
                }
                break;
                case 1: {
                    ConsoleSuperMenu.readSuperResource();
                }
                break;
                case 2: {
                    System.out.println("SUPER => option 2");
                }
                break;
                case 3: {
                    System.out.println("SUPER => option 3");
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitSuperMenu);


    }

    private static void readSuperResource() {
        System.out.println(SUPER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
            ConsoleMenu.displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(SUPER_PRINTING);
    }

    private static void displaySuperMenu() {
        System.out.println("+-------------------+");
        System.out.println("| SUPER MENU        |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit Super     |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. Load database  |");
        System.out.println("| 3. no name option |");
        System.out.println("+-------------------+");

        System.out.println(SELECT_OPTION);
    }
}
