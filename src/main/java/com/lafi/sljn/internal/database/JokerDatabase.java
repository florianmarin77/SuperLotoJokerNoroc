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
    private static JokerDatabase jokerDatabase = null;

    // database resource
    private List<Sample> jokerList = new ArrayList<>();

    // constructor
    private JokerDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized JokerDatabase getInstance() {
        if (jokerDatabase == null) {
            jokerDatabase = new JokerDatabase();
        }
        return jokerDatabase;
    }

    // special methods
    public static List<Sample> loadResource() {
        List<Single> jokerSingles = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(JOKER_PATH).toURI());
            jokerSingles = LOADER.loadData(path);
            System.out.println(JOKER_DATABASE);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        List<Sample> jokerSamples = new ArrayList<>();
        Integer lastJokerIndex = 0;

        for (Single item : jokerSingles) {

            Sample sample = new Sample();
            lastJokerIndex++;

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
            Integer[] decada = new Integer[5];
            StringBuilder string = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                decada[i] = intex[i] / 10;
                codex[decada[i]]++;
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
            sample.setIndex(lastJokerIndex);

            jokerSamples.add(sample);
        }

        JOKERDB.setJokerList(jokerSamples);

        return jokerSamples;
    }

    // getters & setters
    public List<Sample> getJokerList() {
        return jokerList;
    }

    public void setJokerList(List<Sample> jokerList) {
        this.jokerList = jokerList;
    }
}
