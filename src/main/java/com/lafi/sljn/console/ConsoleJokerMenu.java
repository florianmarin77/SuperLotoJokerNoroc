package com.lafi.sljn.console;

import com.lafi.sljn.sample.loaders.SampleLoader;
import com.lafi.sljn.sample.loaders.SingleLoader;
import com.lafi.sljn.sample.models.Sample;
import com.lafi.sljn.sample.models.Single;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.lafi.sljn.sample.messages.CommonMessages.*;

public class ConsoleJokerMenu {
    static void main() {

        boolean exitJokerMenu = false;
        do {
            displayJokerMenu();

            int selectedOption = ConsoleMenu.selectValidOption();

            switch (selectedOption) {
                case 0: {
                    exitJokerMenu = true;
                }
                break;
                case 1: {
                    ConsoleJokerMenu.readJokerResource();
                }
                break;
                case 2: {
                    System.out.println("JOKER => option 2");
                }
                break;
                case 3: {
                    System.out.println("JOKER => option 3");
                }
                break;
                default: {
                    System.out.println(INVALID_OPTION);
                }
                break;
            }
        } while (!exitJokerMenu);
    }

    private static void readJokerResource() {
        System.out.println(JOKER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
            displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(JOKER_PRINTING);
    }

    private static void displaySingles(Path path) {
        SingleLoader loader = new SingleLoader();

        List<Single> singles = loader.loadData(Paths.get(String.valueOf(path)));

        for (Single item : singles) {
            System.out.println(item);
        }
    }

    private static void displaySamples(Path path) {
        SampleLoader loader = new SampleLoader();

        List<Sample> samples = loader.loadData(Paths.get(String.valueOf(path)));

        for (Sample item : samples) {
            System.out.println(item);
        }
    }

    private static void displayJokerMenu() {
        System.out.println("+-------------------+");
        System.out.println("| JOKER MENU        |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit Joker     |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. no name option |");
        System.out.println("| 3. no name option |");
        System.out.println("+-------------------+");

        System.out.println("What do you want to do?");
    }
}
