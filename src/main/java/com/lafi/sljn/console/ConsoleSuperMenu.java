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
                    System.out.println(INVALID_SYSTEM);
                }
                break;
            }
        } while (!exitSuperMenu);


    }

    private static void readSuperResource() {
        System.out.println(SUPER_LOADING);

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
            displaySingles(path);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        System.out.println(SUPER_PRINTING);
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

    private static void displaySuperMenu() {
        System.out.println("SUPER MENU");
        System.out.println("---------");
        System.out.println("0. Exit Super");
        System.out.println("1. Load resource");
        System.out.println("2. no name option");
        System.out.println("3. no name option");
        System.out.println("Select an option:");
    }
}