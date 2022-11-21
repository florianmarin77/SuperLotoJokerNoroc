package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.JokerDatabase;
import com.lafi.sljn.internal.database.LotoDatabase;
import com.lafi.sljn.internal.database.SuperDatabase;
import com.lafi.sljn.internal.loader.ResourceLoader;
import com.lafi.sljn.internal.model.Sample;
import com.lafi.sljn.internal.model.Single;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.lafi.sljn.internal.message.CommonMessages.*;
import static com.lafi.sljn.internal.message.SpecialMessages.*;

public class ConsoleMenu {
    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        // SUPER database
        SuperDatabase.loadResource();

        // LOTO database
        LotoDatabase.loadResource();

        // JOKER database
        JokerDatabase.loadResource();

        // Console Menus
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
                                SuperMenu.main();
                            }
                            break;
                            case 2: {
                                LotoMenu.main();
                            }
                            break;
                            case 3: {
                                JokerMenu.main();
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
        ResourceLoader loader = new ResourceLoader();

        List<Single> singles = loader.loadData(Paths.get(String.valueOf(path)));

        for (Single item : singles) {
            System.out.println(item);
        }
    }

    static void displaySamples(List<Sample> samples) {

        System.out.println(OUTSIDE_LINE);
        System.out.println(TEXT_LINE);
        System.out.println(INSIDE_LINE);

        for (Sample item : samples) {

            System.out.print("| " + item.getDatex() + " | ");

            if (item.getIntex1() < 10) {
                System.out.print("0" + item.getIntex1() + " ");
            } else {
                System.out.print(item.getIntex1() + " ");
            }

            if (item.getIntex2() < 10) {
                System.out.print("0" + item.getIntex2() + " ");
            } else {
                System.out.print(item.getIntex2() + " ");
            }

            if (item.getIntex3() < 10) {
                System.out.print("0" + item.getIntex3() + " ");
            } else {
                System.out.print(item.getIntex3() + " ");
            }

            if (item.getIntex4() < 10) {
                System.out.print("0" + item.getIntex4() + " ");
            } else {
                System.out.print(item.getIntex4() + " ");
            }

            if (item.getIntex5() < 10) {
                System.out.print("0" + item.getIntex5() + " ");
            } else {
                System.out.print(item.getIntex5() + " ");
            }

            if (item.getIntex6() < 10) {
                System.out.print("0" + item.getIntex6() + " | ");
            } else {
                System.out.print(item.getIntex6() + " | ");
            }

            switch (item.getCodex().length()) {
                case 1: {
                    System.out.print(item.getCodex() + "     | ");
                }
                break;
                case 2: {
                    System.out.print(item.getCodex() + "    | ");
                }
                break;
                case 3: {
                    System.out.print(item.getCodex() + "   | ");
                }
                break;
                case 4: {
                    System.out.print(item.getCodex() + "  | ");
                }
                break;
                case 5: {
                    System.out.print(item.getCodex() + " | ");
                }
                break;
            }

            switch (String.valueOf(item.getIndex()).length()) {
                case 1: {
                    System.out.print("0000" + item.getIndex() + " |");
                }
                break;
                case 2: {
                    System.out.print("000" + item.getIndex() + " |");
                }
                break;
                case 3: {
                    System.out.print("00" + item.getIndex() + " |");
                }
                break;
                case 4: {
                    System.out.print("0" + item.getIndex() + " |");
                }
                break;
                case 5: {
                    System.out.print(item.getIndex() + " |");
                }
                break;
            }

            System.out.println();
        }

        System.out.println(OUTSIDE_LINE);
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
