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
                    System.out.println("LOTO => option 2");
                }
                break;
                case 3: {
                    System.out.println("LOTO => option 3");
                }
                break;
                default: {
                    System.out.println(INVALID_SYSTEM);
                }
                break;
            }
        } while (!exitLotoMenu);
    }

    private static void readLotoResource() {
        System.out.println(LOTO_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(LOTO_PATH).toURI());
            displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(LOTO_PRINTING);
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

    private static void displayLotoMenu() {
        System.out.println("+-------------------+");
        System.out.println("| LOTO MENU         |");
        System.out.println("|-------------------|");
        System.out.println("| 0. Exit Loto      |");
        System.out.println("| 1. Load resource  |");
        System.out.println("| 2. no name option |");
        System.out.println("| 3. no name option |");
        System.out.println("+-------------------+");

        System.out.println("What do you want to do?");
    }
}
