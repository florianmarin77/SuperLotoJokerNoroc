package com.lafi.sljn.console;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleMenu {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exitMainMenu = false;
        do {
            displayMainMenu();
            int selectedChoice = SCANNER.nextInt();
            switch (selectedChoice) {
                case 0: {
                    exitMainMenu = true;
                }
                break;
                case 1: {
                    boolean exitStartMenu = false;
                    do {
                        displayStartMenu();
                        int selectedOperation = SCANNER.nextInt();
                        switch (selectedOperation) {
                            case 0: {
                                exitStartMenu = true;
                            }
                            break;
                            case 1: {
                                System.out.println("SUPER 5/40");
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource("super.txt").toURI());
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                            }
                            break;
                            case 2: {
                                System.out.println("LOTO 6/49");
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource("loto.txt").toURI());
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                            }
                            break;
                            case 3: {
                                System.out.println("JOKER 5/45 + 1/20");
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource("joker").toURI());
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                            }
                            break;
                            case 4: {
                                System.out.println("NOROC");
                                try {
                                    Path path = Paths.get(ClassLoader.getSystemResource("noroc").toURI());
                                } catch (URISyntaxException exception) {
                                    exception.printStackTrace();
                                }
                            }
                            break;
                            default: {
                                System.out.println("Please enter a valid operation!");
                            }
                            break;
                        }
                    } while (!exitStartMenu);
                }
                break;
                default: {
                    System.out.println("Please make a valid choice!");
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
        System.out.println("4. Noroc");
        System.out.println("Select an option:");
    }

    private static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("---------");
        System.out.println("0. Exit");
        System.out.println("1. Start");
        System.out.println("Make your choice:");
    }

}
