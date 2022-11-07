package com.lafi.sljn.console;

import com.lafi.sljn.sample.loaders.SampleLoader;
import com.lafi.sljn.sample.loaders.SingleLoader;
import com.lafi.sljn.sample.models.Sample;
import com.lafi.sljn.sample.models.Single;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.lafi.sljn.sample.messages.CommonMessages.*;

public class ConsoleMenu {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exitMainMenu = false;
        do {
            displayMainMenu();

            int selectedChoice;
            while (true) {
                try {
                    selectedChoice = SCANNER.nextInt();
                    break;
                } catch (InputMismatchException exception) {
                    System.out.println(INVALID_NUMBER);
                }
                SCANNER.nextLine();
            }

            switch (selectedChoice) {
                case 0: {
                    exitMainMenu = true;
                }
                break;
                case 1: {
                    boolean exitStartMenu = false;
                    do {
                        displayStartMenu();

                        int selectedSystem;
                        while (true) {
                            try {
                                selectedSystem = SCANNER.nextInt();
                                break;
                            } catch (InputMismatchException exception) {
                                System.out.println(INVALID_NUMBER);
                            }
                            SCANNER.nextLine();
                        }

                        switch (selectedSystem) {
                            case 0: {
                                exitStartMenu = true;
                            }
                            break;
                            case 1: {
                                System.out.println(SUPER_LOADING);
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
                                    displaySingles(path);
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                                System.out.println(SUPER_PRINTING);
                            }
                            break;
                            case 2: {
                                System.out.println(LOTO_LOADING);
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource(LOTO_PATH).toURI());
                                    displaySingles(path);
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                                System.out.println(LOTO_PRINTING);
                            }
                            break;
                            case 3: {
                                System.out.println(JOKER_LOADING);
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
                                    displaySingles(path);
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                                System.out.println(JOKER_PRINTING);
                            }
                            break;
                            default: {
                                System.out.println(INVALID_SYSTEM);
                            }
                            break;
                        }
                    } while (!exitStartMenu);
                }
                break;
                default: {
                    System.out.println(INVALID_CHOICE);
                }
                break;
            }
        } while (!exitMainMenu);
        System.out.println("Thank you!");
    }

    private static void displayStartMenu() {
        System.out.println("START MENU");
        System.out.println("---------");
        System.out.println("0. Main menu");
        System.out.println("1. Super 5/40");
        System.out.println("2. Loto 6/49");
        System.out.println("3. Joker 5/45+1/20");
        System.out.println("Select an option:");
    }

    private static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("---------");
        System.out.println("0. Exit");
        System.out.println("1. Start");
        System.out.println("Make your choice:");
    }

    private static void displaySingles(Path path) {
        SingleLoader loader = new SingleLoader();
        List<Single> singles = loader.loadData(Paths.get(String.valueOf(path)));
    }

    private static void displaySamples(Path path) {
        SampleLoader loader = new SampleLoader();
        List<Sample> samples = loader.loadData(Paths.get(String.valueOf(path)));
    }
}
