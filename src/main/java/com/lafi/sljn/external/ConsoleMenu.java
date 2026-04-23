package com.lafi.sljn.external;

import com.lafi.sljn.internal.database.JokerDatabase;
import com.lafi.sljn.internal.database.LotoDatabase;
import com.lafi.sljn.internal.database.SuperDatabase;
import com.lafi.sljn.internal.model.Sample;
import com.lafi.sljn.internal.model.Single;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.lafi.sljn.internal.message.CommonMessages.*;
import static com.lafi.sljn.internal.message.SpecialMessages.*;

public class ConsoleMenu {
    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        // SUPER database
        SuperDatabase.loadResources();
        SuperDatabase.loadFrequencies();
        SuperDatabase.loadDistances();

        // LOTO database
        LotoDatabase.loadResources();
        LotoDatabase.loadFrequencies();
        LotoDatabase.loadDistances();

        // JOKER database
        JokerDatabase.loadResources();
        JokerDatabase.loadFrequencies();
        JokerDatabase.loadSpecialFrequencies();
        JokerDatabase.loadDistances();
        JokerDatabase.loadSpecialDistances();

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

    private static void displayMainMenu() {
        System.out.println("+-----------+");
        System.out.println("| MAIN MENU |");
        System.out.println("|-----------|");
        System.out.println("| 0. Exit   |");
        System.out.println("| 1. Start  |");
        System.out.println("+-----------+");

        System.out.println(SELECT_OPTION);
    }

    private static void displayStartMenu() {
        System.out.println("+---------------+");
        System.out.println("| START MENU    |");
        System.out.println("|---------------|");
        System.out.println("| 0. Main menu  |");
        System.out.println("| 1. Super 5/40 |");
        System.out.println("| 2. Loto 6/49  |");
        System.out.println("| 3. Joker 5/45 |");
        System.out.println("+---------------+");

        System.out.println(SELECT_OPTION);
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

    static void displaySingles(List<Single> singles, int marker) {
        for (Single item : singles) {
            System.out.println(item);
        }
    }

    static void displaySamples(List<Sample> samples, int marker) {
        System.out.println(OUTSIDE_LINE_TAB_0);

        switch (marker) {
            case 40: {
                System.out.println(FIRST_LINE_SUPER_TAB_0);
            }
            break;
            case 49: {
                System.out.println(FIRST_LINE_LOTO_TAB_0);
            }
            break;
            case 45: {
                System.out.println(FIRST_LINE_JOKER_TAB_0);
            }
            break;
        }

        System.out.println(INSIDE_LINE_TAB_0);
        System.out.println(SECOND_LINE_TAB_0);
        System.out.println(INSIDE_LINE_TAB_0);

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

        System.out.println(INSIDE_LINE_TAB_0);
        System.out.println(SECOND_LINE_TAB_0);
        System.out.println(OUTSIDE_LINE_TAB_0);
    }

    static void displayFrequencies(List<Integer> absolutes, List<Integer> relatives, int marker) {
        System.out.println(OUTSIDE_LINE_TAB_1);

        switch (marker) {
            case 40: {
                System.out.println(FIRST_LINE_SUPER_TAB_1);
            }
            break;
            case 49: {
                System.out.println(FIRST_LINE_LOTO_TAB_1);
            }
            break;
            case 45:
            case 20: {
                System.out.println(FIRST_LINE_JOKER_TAB_1);
            }
            break;
        }

        System.out.println(INSIDE_LINE_TAB_1);
        System.out.println(SECOND_LINE_TAB_1);
        System.out.println(INSIDE_LINE_TAB_1);

        for (int firstCounter = 1; firstCounter < marker + 1; firstCounter++) {
            System.out.print("| ");
            if (firstCounter < 10) {
                System.out.print("0" + firstCounter + "     ");
            } else {
                System.out.print(firstCounter + "     ");
            }

            int absoluteDigits = String.valueOf(absolutes.get(firstCounter - 1)).length();
            int relativeDigits = String.valueOf(relatives.get(firstCounter - 1)).length();
            final int blankSpaces = 8;

            System.out.print("| " + absolutes.get(firstCounter - 1));
            for (int secondCounter = 0; secondCounter < blankSpaces - absoluteDigits; secondCounter++) {
                System.out.print(" ");
            }

            System.out.print(" | " + relatives.get(firstCounter - 1));
            for (int secondCounter = 0; secondCounter < blankSpaces - relativeDigits; secondCounter++) {
                System.out.print(" ");
            }

            System.out.print(" |");
            System.out.println();
        }

        System.out.println(INSIDE_LINE_TAB_1);
        System.out.println(SECOND_LINE_TAB_1);
        System.out.println(OUTSIDE_LINE_TAB_1);
    }

    static void displayDistances(List<Integer> indexes, List<Integer> positives, List<Integer> negatives, int marker) {
        System.out.println(OUTSIDE_LINE_TAB_2);

        switch (marker) {
            case 40: {
                System.out.println(FIRST_LINE_SUPER_TAB_2);
            }
            break;
            case 49: {
                System.out.println(FIRST_LINE_LOTO_TAB_2);
            }
            break;
            case 45:
            case 20: {
                System.out.println(FIRST_LINE_JOKER_TAB_2);
            }
            break;
        }

        System.out.println(INSIDE_LINE_TAB_2);
        System.out.println(SECOND_LINE_TAB_2);
        System.out.println(INSIDE_LINE_TAB_2);

        for (int firstCounter = 1; firstCounter < marker + 1; firstCounter++) {
            System.out.print("| ");
            if (firstCounter < 10) {
                System.out.print("0" + firstCounter + "     ");
            } else {
                System.out.print(firstCounter + "     ");
            }

            final int firstSpaces = 5;
            final int secondSpaces = 8;
            final int thirdSpaces = 8;

            int firstDigits = String.valueOf(indexes.get(firstCounter - 1)).length();
            int secondDigits = String.valueOf(positives.get(firstCounter - 1)).length();
            int thirdDigits = String.valueOf(negatives.get(firstCounter - 1)).length();

            System.out.print("| " + indexes.get(firstCounter - 1));
            for (int secondCounter = 0; secondCounter < firstSpaces - firstDigits; secondCounter++) {
                System.out.print(" ");
            }

            System.out.print(" | " + positives.get(firstCounter - 1));
            for (int secondCounter = 0; secondCounter < secondSpaces - secondDigits; secondCounter++) {
                System.out.print(" ");
            }

            System.out.print(" | " + negatives.get(firstCounter - 1));
            for (int secondCounter = 0; secondCounter < thirdSpaces - thirdDigits; secondCounter++) {
                System.out.print(" ");
            }

            System.out.print(" |");
            System.out.println();
        }

        System.out.println(INSIDE_LINE_TAB_2);
        System.out.println(SECOND_LINE_TAB_2);
        System.out.println(OUTSIDE_LINE_TAB_2);
    }
}
