package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.model.Sample;
import com.lafi.sljn.internal.model.Single;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.lafi.sljn.internal.database.Database.JOKERDB;
import static com.lafi.sljn.internal.database.Database.LOADER;
import static com.lafi.sljn.internal.message.CommonMessages.JOKER_DATABASE;
import static com.lafi.sljn.internal.message.CommonMessages.JOKER_PATH;

public class JokerDatabase {

    // Singleton pattern
    private static JokerDatabase database = null;

    // database resources
    private List<Single> singles = new ArrayList<>();
    private List<Sample> samples = new ArrayList<>();

    // database frequencies
    private List<Integer> absolutes = new ArrayList<>();
    private List<Integer> relatives = new ArrayList<>();
    private List<Integer> specialAbsolutes = new ArrayList<>();
    private List<Integer> specialRelatives = new ArrayList<>();

    // database distances
    private List<Integer> indexes = new ArrayList<>();
    private List<Integer> positives = new ArrayList<>();
    private List<Integer> negatives = new ArrayList<>();
    private List<Integer> specialIndexes = new ArrayList<>();
    private List<Integer> specialPositives = new ArrayList<>();
    private List<Integer> specialNegatives = new ArrayList<>();

    // constructor
    private JokerDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized JokerDatabase getInstance() {
        if (database == null) {
            database = new JokerDatabase();
        }
        return database;
    }

    /* ==================================================> special methods */

    public static void loadResources() {
        List<Single> singles = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
            singles = LOADER.loadData(path);
            System.out.println(JOKER_DATABASE);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        List<Sample> samples = new ArrayList<>();
        Integer lastIndex = 0;

        for (Single item : singles) {

            Sample sample = new Sample();
            lastIndex++;

            // DATEX ready
            sample.setDatex(item.getDatex());

            //INTEX ready
            sample.setIntex1(Integer.valueOf(item.getIntex1()));
            sample.setIntex2(Integer.valueOf(item.getIntex2()));
            sample.setIntex3(Integer.valueOf(item.getIntex3()));
            sample.setIntex4(Integer.valueOf(item.getIntex4()));
            sample.setIntex5(Integer.valueOf(item.getIntex5()));
            sample.setIntex6(Integer.valueOf(item.getIntex6()));

            // preparing CODEX
            Integer[] intex = new Integer[5];

            intex[0] = sample.getIntex1();
            intex[1] = sample.getIntex2();
            intex[2] = sample.getIntex3();
            intex[3] = sample.getIntex4();
            intex[4] = sample.getIntex5();

            Integer[] codex = {0, 0, 0, 0, 0};
            Integer[] decade = new Integer[5];
            StringBuilder string = new StringBuilder();

            for (int counter = 0; counter < 5; counter++) {
                decade[counter] = intex[counter] / 10;
                codex[decade[counter]]++;
            }

            Arrays.sort(codex, Collections.reverseOrder());

            for (int counter = 0; counter < 5; counter++) {
                if (codex[counter] != 0) {
                    string.append(codex[counter].toString());
                }
            }

            // CODEX ready
            sample.setCodex(string.toString());

            // INDEX ready
            sample.setIndex(lastIndex);

            samples.add(sample);
        }

        JOKERDB.setSingles(singles);
        JOKERDB.setSamples(samples);
    }

    public static void loadFrequencies() {
        List<Sample> samples = JOKERDB.getSamples();

        Integer[] results = new Integer[45];
        for (int counter = 0; counter < 45; counter++) {
            results[counter] = 0;
        }

        for (Sample item : samples) {
            // INTEX 1
            switch (item.getIntex1()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
                case 21: {
                    results[20]++;
                }
                break;
                case 22: {
                    results[21]++;
                }
                break;
                case 23: {
                    results[22]++;
                }
                break;
                case 24: {
                    results[23]++;
                }
                break;
                case 25: {
                    results[24]++;
                }
                break;
                case 26: {
                    results[25]++;
                }
                break;
                case 27: {
                    results[26]++;
                }
                break;
                case 28: {
                    results[27]++;
                }
                break;
                case 29: {
                    results[28]++;
                }
                break;
                case 30: {
                    results[29]++;
                }
                break;
                case 31: {
                    results[30]++;
                }
                break;
                case 32: {
                    results[31]++;
                }
                break;
                case 33: {
                    results[32]++;
                }
                break;
                case 34: {
                    results[33]++;
                }
                break;
                case 35: {
                    results[34]++;
                }
                break;
                case 36: {
                    results[35]++;
                }
                break;
                case 37: {
                    results[36]++;
                }
                break;
                case 38: {
                    results[37]++;
                }
                break;
                case 39: {
                    results[38]++;
                }
                break;
                case 40: {
                    results[39]++;
                }
                break;
                case 41: {
                    results[40]++;
                }
                break;
                case 42: {
                    results[41]++;
                }
                break;
                case 43: {
                    results[42]++;
                }
                break;
                case 44: {
                    results[43]++;
                }
                break;
                case 45: {
                    results[44]++;
                }
                break;
            }

            // INTEX 2
            switch (item.getIntex2()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
                case 21: {
                    results[20]++;
                }
                break;
                case 22: {
                    results[21]++;
                }
                break;
                case 23: {
                    results[22]++;
                }
                break;
                case 24: {
                    results[23]++;
                }
                break;
                case 25: {
                    results[24]++;
                }
                break;
                case 26: {
                    results[25]++;
                }
                break;
                case 27: {
                    results[26]++;
                }
                break;
                case 28: {
                    results[27]++;
                }
                break;
                case 29: {
                    results[28]++;
                }
                break;
                case 30: {
                    results[29]++;
                }
                break;
                case 31: {
                    results[30]++;
                }
                break;
                case 32: {
                    results[31]++;
                }
                break;
                case 33: {
                    results[32]++;
                }
                break;
                case 34: {
                    results[33]++;
                }
                break;
                case 35: {
                    results[34]++;
                }
                break;
                case 36: {
                    results[35]++;
                }
                break;
                case 37: {
                    results[36]++;
                }
                break;
                case 38: {
                    results[37]++;
                }
                break;
                case 39: {
                    results[38]++;
                }
                break;
                case 40: {
                    results[39]++;
                }
                break;
                case 41: {
                    results[40]++;
                }
                break;
                case 42: {
                    results[41]++;
                }
                break;
                case 43: {
                    results[42]++;
                }
                break;
                case 44: {
                    results[43]++;
                }
                break;
                case 45: {
                    results[44]++;
                }
                break;
            }

            // INTEX 3
            switch (item.getIntex3()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
                case 21: {
                    results[20]++;
                }
                break;
                case 22: {
                    results[21]++;
                }
                break;
                case 23: {
                    results[22]++;
                }
                break;
                case 24: {
                    results[23]++;
                }
                break;
                case 25: {
                    results[24]++;
                }
                break;
                case 26: {
                    results[25]++;
                }
                break;
                case 27: {
                    results[26]++;
                }
                break;
                case 28: {
                    results[27]++;
                }
                break;
                case 29: {
                    results[28]++;
                }
                break;
                case 30: {
                    results[29]++;
                }
                break;
                case 31: {
                    results[30]++;
                }
                break;
                case 32: {
                    results[31]++;
                }
                break;
                case 33: {
                    results[32]++;
                }
                break;
                case 34: {
                    results[33]++;
                }
                break;
                case 35: {
                    results[34]++;
                }
                break;
                case 36: {
                    results[35]++;
                }
                break;
                case 37: {
                    results[36]++;
                }
                break;
                case 38: {
                    results[37]++;
                }
                break;
                case 39: {
                    results[38]++;
                }
                break;
                case 40: {
                    results[39]++;
                }
                break;
                case 41: {
                    results[40]++;
                }
                break;
                case 42: {
                    results[41]++;
                }
                break;
                case 43: {
                    results[42]++;
                }
                break;
                case 44: {
                    results[43]++;
                }
                break;
                case 45: {
                    results[44]++;
                }
                break;
            }

            // INTEX 4
            switch (item.getIntex4()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
                case 21: {
                    results[20]++;
                }
                break;
                case 22: {
                    results[21]++;
                }
                break;
                case 23: {
                    results[22]++;
                }
                break;
                case 24: {
                    results[23]++;
                }
                break;
                case 25: {
                    results[24]++;
                }
                break;
                case 26: {
                    results[25]++;
                }
                break;
                case 27: {
                    results[26]++;
                }
                break;
                case 28: {
                    results[27]++;
                }
                break;
                case 29: {
                    results[28]++;
                }
                break;
                case 30: {
                    results[29]++;
                }
                break;
                case 31: {
                    results[30]++;
                }
                break;
                case 32: {
                    results[31]++;
                }
                break;
                case 33: {
                    results[32]++;
                }
                break;
                case 34: {
                    results[33]++;
                }
                break;
                case 35: {
                    results[34]++;
                }
                break;
                case 36: {
                    results[35]++;
                }
                break;
                case 37: {
                    results[36]++;
                }
                break;
                case 38: {
                    results[37]++;
                }
                break;
                case 39: {
                    results[38]++;
                }
                break;
                case 40: {
                    results[39]++;
                }
                break;
                case 41: {
                    results[40]++;
                }
                break;
                case 42: {
                    results[41]++;
                }
                break;
                case 43: {
                    results[42]++;
                }
                break;
                case 44: {
                    results[43]++;
                }
                break;
                case 45: {
                    results[44]++;
                }
                break;
            }

            // INTEX 5
            switch (item.getIntex5()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
                case 21: {
                    results[20]++;
                }
                break;
                case 22: {
                    results[21]++;
                }
                break;
                case 23: {
                    results[22]++;
                }
                break;
                case 24: {
                    results[23]++;
                }
                break;
                case 25: {
                    results[24]++;
                }
                break;
                case 26: {
                    results[25]++;
                }
                break;
                case 27: {
                    results[26]++;
                }
                break;
                case 28: {
                    results[27]++;
                }
                break;
                case 29: {
                    results[28]++;
                }
                break;
                case 30: {
                    results[29]++;
                }
                break;
                case 31: {
                    results[30]++;
                }
                break;
                case 32: {
                    results[31]++;
                }
                break;
                case 33: {
                    results[32]++;
                }
                break;
                case 34: {
                    results[33]++;
                }
                break;
                case 35: {
                    results[34]++;
                }
                break;
                case 36: {
                    results[35]++;
                }
                break;
                case 37: {
                    results[36]++;
                }
                break;
                case 38: {
                    results[37]++;
                }
                break;
                case 39: {
                    results[38]++;
                }
                break;
                case 40: {
                    results[39]++;
                }
                break;
                case 41: {
                    results[40]++;
                }
                break;
                case 42: {
                    results[41]++;
                }
                break;
                case 43: {
                    results[42]++;
                }
                break;
                case 44: {
                    results[43]++;
                }
                break;
                case 45: {
                    results[44]++;
                }
                break;
            }
        }

        // preparing ABSOLUTES
        List<Integer> absolutes = new ArrayList<>(Arrays.asList(results).subList(0, 45));

        // preparing RELATIVES
        List<Integer> relatives = new ArrayList<>();
        Integer minim = Collections.min(absolutes);
        for (Integer item : absolutes) {
            relatives.add(item - minim);
        }

        // FREQUENCIES ready
        JOKERDB.setAbsolutes(absolutes);
        JOKERDB.setRelatives(relatives);
    }

    public static void loadSpecialFrequencies() {
        List<Sample> samples = JOKERDB.getSamples();

        Integer[] results = new Integer[20];
        for (int counter = 0; counter < 20; counter++) {
            results[counter] = 0;
        }

        for (Sample item : samples) {
            // INTEX 6
            switch (item.getIntex6()) {
                case 1: {
                    results[0]++;
                }
                break;
                case 2: {
                    results[1]++;
                }
                break;
                case 3: {
                    results[2]++;
                }
                break;
                case 4: {
                    results[3]++;
                }
                break;
                case 5: {
                    results[4]++;
                }
                break;
                case 6: {
                    results[5]++;
                }
                break;
                case 7: {
                    results[6]++;
                }
                break;
                case 8: {
                    results[7]++;
                }
                break;
                case 9: {
                    results[8]++;
                }
                break;
                case 10: {
                    results[9]++;
                }
                break;
                case 11: {
                    results[10]++;
                }
                break;
                case 12: {
                    results[11]++;
                }
                break;
                case 13: {
                    results[12]++;
                }
                break;
                case 14: {
                    results[13]++;
                }
                break;
                case 15: {
                    results[14]++;
                }
                break;
                case 16: {
                    results[15]++;
                }
                break;
                case 17: {
                    results[16]++;
                }
                break;
                case 18: {
                    results[17]++;
                }
                break;
                case 19: {
                    results[18]++;
                }
                break;
                case 20: {
                    results[19]++;
                }
                break;
            }
        }

        // preparing SPECIAL ABSOLUTES
        List<Integer> absolutes = new ArrayList<>(Arrays.asList(results).subList(0, 20));

        // preparing SPECIAL RELATIVES
        List<Integer> relatives = new ArrayList<>();
        Integer minim = Collections.min(absolutes);
        for (Integer item : absolutes) {
            relatives.add(item - minim);
        }

        // SPECIAL FREQUENCIES ready
        JOKERDB.setSpecialAbsolutes(absolutes);
        JOKERDB.setSpecialRelatives(relatives);
    }

    public static void loadDistances() {
        List<Sample> samples = JOKERDB.getSamples();

        Integer[] results = new Integer[45];
        for (int counter = 0; counter < 45; counter++) {
            results[counter] = 0;
        }

        for (Sample item : samples) {
            // INTEX 1
            switch (item.getIntex1()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
                case 21: {
                    results[20] = item.getIndex();
                }
                break;
                case 22: {
                    results[21] = item.getIndex();
                }
                break;
                case 23: {
                    results[22] = item.getIndex();
                }
                break;
                case 24: {
                    results[23] = item.getIndex();
                }
                break;
                case 25: {
                    results[24] = item.getIndex();
                }
                break;
                case 26: {
                    results[25] = item.getIndex();
                }
                break;
                case 27: {
                    results[26] = item.getIndex();
                }
                break;
                case 28: {
                    results[27] = item.getIndex();
                }
                break;
                case 29: {
                    results[28] = item.getIndex();
                }
                break;
                case 30: {
                    results[29] = item.getIndex();
                }
                break;
                case 31: {
                    results[30] = item.getIndex();
                }
                break;
                case 32: {
                    results[31] = item.getIndex();
                }
                break;
                case 33: {
                    results[32] = item.getIndex();
                }
                break;
                case 34: {
                    results[33] = item.getIndex();
                }
                break;
                case 35: {
                    results[34] = item.getIndex();
                }
                break;
                case 36: {
                    results[35] = item.getIndex();
                }
                break;
                case 37: {
                    results[36] = item.getIndex();
                }
                break;
                case 38: {
                    results[37] = item.getIndex();
                }
                break;
                case 39: {
                    results[38] = item.getIndex();
                }
                break;
                case 40: {
                    results[39] = item.getIndex();
                }
                break;
                case 41: {
                    results[40] = item.getIndex();
                }
                break;
                case 42: {
                    results[41] = item.getIndex();
                }
                break;
                case 43: {
                    results[42] = item.getIndex();
                }
                break;
                case 44: {
                    results[43] = item.getIndex();
                }
                break;
                case 45: {
                    results[44] = item.getIndex();
                }
                break;
            }

            // INTEX 2
            switch (item.getIntex2()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
                case 21: {
                    results[20] = item.getIndex();
                }
                break;
                case 22: {
                    results[21] = item.getIndex();
                }
                break;
                case 23: {
                    results[22] = item.getIndex();
                }
                break;
                case 24: {
                    results[23] = item.getIndex();
                }
                break;
                case 25: {
                    results[24] = item.getIndex();
                }
                break;
                case 26: {
                    results[25] = item.getIndex();
                }
                break;
                case 27: {
                    results[26] = item.getIndex();
                }
                break;
                case 28: {
                    results[27] = item.getIndex();
                }
                break;
                case 29: {
                    results[28] = item.getIndex();
                }
                break;
                case 30: {
                    results[29] = item.getIndex();
                }
                break;
                case 31: {
                    results[30] = item.getIndex();
                }
                break;
                case 32: {
                    results[31] = item.getIndex();
                }
                break;
                case 33: {
                    results[32] = item.getIndex();
                }
                break;
                case 34: {
                    results[33] = item.getIndex();
                }
                break;
                case 35: {
                    results[34] = item.getIndex();
                }
                break;
                case 36: {
                    results[35] = item.getIndex();
                }
                break;
                case 37: {
                    results[36] = item.getIndex();
                }
                break;
                case 38: {
                    results[37] = item.getIndex();
                }
                break;
                case 39: {
                    results[38] = item.getIndex();
                }
                break;
                case 40: {
                    results[39] = item.getIndex();
                }
                break;
                case 41: {
                    results[40] = item.getIndex();
                }
                break;
                case 42: {
                    results[41] = item.getIndex();
                }
                break;
                case 43: {
                    results[42] = item.getIndex();
                }
                break;
                case 44: {
                    results[43] = item.getIndex();
                }
                break;
                case 45: {
                    results[44] = item.getIndex();
                }
                break;
            }

            // INTEX 3
            switch (item.getIntex3()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
                case 21: {
                    results[20] = item.getIndex();
                }
                break;
                case 22: {
                    results[21] = item.getIndex();
                }
                break;
                case 23: {
                    results[22] = item.getIndex();
                }
                break;
                case 24: {
                    results[23] = item.getIndex();
                }
                break;
                case 25: {
                    results[24] = item.getIndex();
                }
                break;
                case 26: {
                    results[25] = item.getIndex();
                }
                break;
                case 27: {
                    results[26] = item.getIndex();
                }
                break;
                case 28: {
                    results[27] = item.getIndex();
                }
                break;
                case 29: {
                    results[28] = item.getIndex();
                }
                break;
                case 30: {
                    results[29] = item.getIndex();
                }
                break;
                case 31: {
                    results[30] = item.getIndex();
                }
                break;
                case 32: {
                    results[31] = item.getIndex();
                }
                break;
                case 33: {
                    results[32] = item.getIndex();
                }
                break;
                case 34: {
                    results[33] = item.getIndex();
                }
                break;
                case 35: {
                    results[34] = item.getIndex();
                }
                break;
                case 36: {
                    results[35] = item.getIndex();
                }
                break;
                case 37: {
                    results[36] = item.getIndex();
                }
                break;
                case 38: {
                    results[37] = item.getIndex();
                }
                break;
                case 39: {
                    results[38] = item.getIndex();
                }
                break;
                case 40: {
                    results[39] = item.getIndex();
                }
                break;
                case 41: {
                    results[40] = item.getIndex();
                }
                break;
                case 42: {
                    results[41] = item.getIndex();
                }
                break;
                case 43: {
                    results[42] = item.getIndex();
                }
                break;
                case 44: {
                    results[43] = item.getIndex();
                }
                break;
                case 45: {
                    results[44] = item.getIndex();
                }
                break;
            }

            // INTEX 4
            switch (item.getIntex4()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
                case 21: {
                    results[20] = item.getIndex();
                }
                break;
                case 22: {
                    results[21] = item.getIndex();
                }
                break;
                case 23: {
                    results[22] = item.getIndex();
                }
                break;
                case 24: {
                    results[23] = item.getIndex();
                }
                break;
                case 25: {
                    results[24] = item.getIndex();
                }
                break;
                case 26: {
                    results[25] = item.getIndex();
                }
                break;
                case 27: {
                    results[26] = item.getIndex();
                }
                break;
                case 28: {
                    results[27] = item.getIndex();
                }
                break;
                case 29: {
                    results[28] = item.getIndex();
                }
                break;
                case 30: {
                    results[29] = item.getIndex();
                }
                break;
                case 31: {
                    results[30] = item.getIndex();
                }
                break;
                case 32: {
                    results[31] = item.getIndex();
                }
                break;
                case 33: {
                    results[32] = item.getIndex();
                }
                break;
                case 34: {
                    results[33] = item.getIndex();
                }
                break;
                case 35: {
                    results[34] = item.getIndex();
                }
                break;
                case 36: {
                    results[35] = item.getIndex();
                }
                break;
                case 37: {
                    results[36] = item.getIndex();
                }
                break;
                case 38: {
                    results[37] = item.getIndex();
                }
                break;
                case 39: {
                    results[38] = item.getIndex();
                }
                break;
                case 40: {
                    results[39] = item.getIndex();
                }
                break;
                case 41: {
                    results[40] = item.getIndex();
                }
                break;
                case 42: {
                    results[41] = item.getIndex();
                }
                break;
                case 43: {
                    results[42] = item.getIndex();
                }
                break;
                case 44: {
                    results[43] = item.getIndex();
                }
                break;
                case 45: {
                    results[44] = item.getIndex();
                }
                break;
            }

            // INTEX 5
            switch (item.getIntex5()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
                case 21: {
                    results[20] = item.getIndex();
                }
                break;
                case 22: {
                    results[21] = item.getIndex();
                }
                break;
                case 23: {
                    results[22] = item.getIndex();
                }
                break;
                case 24: {
                    results[23] = item.getIndex();
                }
                break;
                case 25: {
                    results[24] = item.getIndex();
                }
                break;
                case 26: {
                    results[25] = item.getIndex();
                }
                break;
                case 27: {
                    results[26] = item.getIndex();
                }
                break;
                case 28: {
                    results[27] = item.getIndex();
                }
                break;
                case 29: {
                    results[28] = item.getIndex();
                }
                break;
                case 30: {
                    results[29] = item.getIndex();
                }
                break;
                case 31: {
                    results[30] = item.getIndex();
                }
                break;
                case 32: {
                    results[31] = item.getIndex();
                }
                break;
                case 33: {
                    results[32] = item.getIndex();
                }
                break;
                case 34: {
                    results[33] = item.getIndex();
                }
                break;
                case 35: {
                    results[34] = item.getIndex();
                }
                break;
                case 36: {
                    results[35] = item.getIndex();
                }
                break;
                case 37: {
                    results[36] = item.getIndex();
                }
                break;
                case 38: {
                    results[37] = item.getIndex();
                }
                break;
                case 39: {
                    results[38] = item.getIndex();
                }
                break;
                case 40: {
                    results[39] = item.getIndex();
                }
                break;
                case 41: {
                    results[40] = item.getIndex();
                }
                break;
                case 42: {
                    results[41] = item.getIndex();
                }
                break;
                case 43: {
                    results[42] = item.getIndex();
                }
                break;
                case 44: {
                    results[43] = item.getIndex();
                }
                break;
                case 45: {
                    results[44] = item.getIndex();
                }
                break;
            }
        }

        // preparing INDEXES
        List<Integer> indexes = new ArrayList<>(Arrays.asList(results).subList(0, 45));

        // preparing DISTANCES
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        Integer maxim = Collections.max(indexes);
        Integer minim = Collections.min(indexes);
        for (Integer item : indexes) {
            positives.add(maxim - item);
            negatives.add(item - minim);
        }

        // DISTANCES ready
        JOKERDB.setIndexes(indexes);
        JOKERDB.setPositives(positives);
        JOKERDB.setNegatives(negatives);
    }

    public static void loadSpecialDistances() {
        List<Sample> samples = JOKERDB.getSamples();

        Integer[] results = new Integer[20];
        for (int counter = 0; counter < 20; counter++) {
            results[counter] = 0;
        }

        for (Sample item : samples) {
            // INTEX 6
            switch (item.getIntex6()) {
                case 1: {
                    results[0] = item.getIndex();
                }
                break;
                case 2: {
                    results[1] = item.getIndex();
                }
                break;
                case 3: {
                    results[2] = item.getIndex();
                }
                break;
                case 4: {
                    results[3] = item.getIndex();
                }
                break;
                case 5: {
                    results[4] = item.getIndex();
                }
                break;
                case 6: {
                    results[5] = item.getIndex();
                }
                break;
                case 7: {
                    results[6] = item.getIndex();
                }
                break;
                case 8: {
                    results[7] = item.getIndex();
                }
                break;
                case 9: {
                    results[8] = item.getIndex();
                }
                break;
                case 10: {
                    results[9] = item.getIndex();
                }
                break;
                case 11: {
                    results[10] = item.getIndex();
                }
                break;
                case 12: {
                    results[11] = item.getIndex();
                }
                break;
                case 13: {
                    results[12] = item.getIndex();
                }
                break;
                case 14: {
                    results[13] = item.getIndex();
                }
                break;
                case 15: {
                    results[14] = item.getIndex();
                }
                break;
                case 16: {
                    results[15] = item.getIndex();
                }
                break;
                case 17: {
                    results[16] = item.getIndex();
                }
                break;
                case 18: {
                    results[17] = item.getIndex();
                }
                break;
                case 19: {
                    results[18] = item.getIndex();
                }
                break;
                case 20: {
                    results[19] = item.getIndex();
                }
                break;
            }
        }

        // preparing SPECIAL INDEXES
        List<Integer> indexes = new ArrayList<>(Arrays.asList(results).subList(0, 20));

        // preparing SPECIAL DISTANCES
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        Integer maxim = Collections.max(indexes);
        Integer minim = Collections.min(indexes);
        for (Integer item : indexes) {
            positives.add(maxim - item);
            negatives.add(item - minim);
        }

        // SPECIAL DISTANCES ready
        JOKERDB.setSpecialIndexes(indexes);
        JOKERDB.setSpecialPositives(positives);
        JOKERDB.setSpecialNegatives(negatives);
    }

    /* ==================================================> getters & setters */

    public List<Single> getSingles() {
        return singles;
    }

    public void setSingles(List<Single> singles) {
        this.singles = singles;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    public List<Integer> getAbsolutes() {
        return absolutes;
    }

    public void setAbsolutes(List<Integer> absolutes) {
        this.absolutes = absolutes;
    }

    public List<Integer> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Integer> relatives) {
        this.relatives = relatives;
    }

    public List<Integer> getSpecialAbsolutes() {
        return specialAbsolutes;
    }

    public void setSpecialAbsolutes(List<Integer> specialAbsolutes) {
        this.specialAbsolutes = specialAbsolutes;
    }

    public List<Integer> getSpecialRelatives() {
        return specialRelatives;
    }

    public void setSpecialRelatives(List<Integer> specialRelatives) {
        this.specialRelatives = specialRelatives;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public List<Integer> getPositives() {
        return positives;
    }

    public void setPositives(List<Integer> positives) {
        this.positives = positives;
    }

    public List<Integer> getNegatives() {
        return negatives;
    }

    public void setNegatives(List<Integer> negatives) {
        this.negatives = negatives;
    }

    public List<Integer> getSpecialIndexes() {
        return specialIndexes;
    }

    public void setSpecialIndexes(List<Integer> specialIndexes) {
        this.specialIndexes = specialIndexes;
    }

    public List<Integer> getSpecialPositives() {
        return specialPositives;
    }

    public void setSpecialPositives(List<Integer> specialPositives) {
        this.specialPositives = specialPositives;
    }

    public List<Integer> getSpecialNegatives() {
        return specialNegatives;
    }

    public void setSpecialNegatives(List<Integer> specialNegatives) {
        this.specialNegatives = specialNegatives;
    }
}
