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

            for (int i = 0; i < 5; i++) {
                decade[i] = intex[i] / 10;
                codex[decade[i]]++;
            }

            Arrays.sort(codex, Collections.reverseOrder());

            for (int i = 0; i < 5; i++) {
                if (codex[i] != 0) {
                    string.append(codex[i].toString());
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

        Integer[] frequencies = new Integer[45];
        for (int k = 0; k < 45; k++) {
            frequencies[k] = 0;
        }

        for (Sample item : samples) {
            // INTEX 1
            switch (item.getIntex1()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
                case 41: {
                    frequencies[40]++;
                }
                break;
                case 42: {
                    frequencies[41]++;
                }
                break;
                case 43: {
                    frequencies[42]++;
                }
                break;
                case 44: {
                    frequencies[43]++;
                }
                break;
                case 45: {
                    frequencies[44]++;
                }
                break;
            }

            // INTEX 2
            switch (item.getIntex2()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
                case 41: {
                    frequencies[40]++;
                }
                break;
                case 42: {
                    frequencies[41]++;
                }
                break;
                case 43: {
                    frequencies[42]++;
                }
                break;
                case 44: {
                    frequencies[43]++;
                }
                break;
                case 45: {
                    frequencies[44]++;
                }
                break;
            }

            // INTEX 3
            switch (item.getIntex3()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
                case 41: {
                    frequencies[40]++;
                }
                break;
                case 42: {
                    frequencies[41]++;
                }
                break;
                case 43: {
                    frequencies[42]++;
                }
                break;
                case 44: {
                    frequencies[43]++;
                }
                break;
                case 45: {
                    frequencies[44]++;
                }
                break;
            }

            // INTEX 4
            switch (item.getIntex4()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
                case 41: {
                    frequencies[40]++;
                }
                break;
                case 42: {
                    frequencies[41]++;
                }
                break;
                case 43: {
                    frequencies[42]++;
                }
                break;
                case 44: {
                    frequencies[43]++;
                }
                break;
                case 45: {
                    frequencies[44]++;
                }
                break;
            }

            // INTEX 5
            switch (item.getIntex5()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
                case 41: {
                    frequencies[40]++;
                }
                break;
                case 42: {
                    frequencies[41]++;
                }
                break;
                case 43: {
                    frequencies[42]++;
                }
                break;
                case 44: {
                    frequencies[43]++;
                }
                break;
                case 45: {
                    frequencies[44]++;
                }
                break;
            }
        }

        // preparing ABSOLUTES
        List<Integer> absolutes = new ArrayList<>(Arrays.asList(frequencies).subList(0, 45));

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

        Integer[] frequencies = new Integer[20];
        for (int k = 0; k < 20; k++) {
            frequencies[k] = 0;
        }

        for (Sample item : samples) {
            // INTEX 6
            switch (item.getIntex6()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
            }
        }

        // preparing SPECIAL ABSOLUTES
        List<Integer> specialAbsolutes = new ArrayList<>(Arrays.asList(frequencies).subList(0, 20));

        // preparing SPECIAL RELATIVES
        List<Integer> specialRelatives = new ArrayList<>();
        Integer minim = Collections.min(specialAbsolutes);
        for (Integer item : specialAbsolutes) {
            specialRelatives.add(item - minim);
        }

        // SPECIAL FREQUENCIES ready
        JOKERDB.setSpecialAbsolutes(specialAbsolutes);
        JOKERDB.setSpecialRelatives(specialRelatives);
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
}
