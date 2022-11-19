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

import static com.lafi.sljn.internal.database.Database.LOADER;
import static com.lafi.sljn.internal.database.Database.LOTODB;
import static com.lafi.sljn.internal.message.CommonMessages.LOTO_DATABASE;
import static com.lafi.sljn.internal.message.CommonMessages.LOTO_PATH;

public class LotoDatabase {

    // Singleton pattern
    private static LotoDatabase lotoDatabase = null;

    // database resource
    private List<Sample> lotoList = new ArrayList<>();

    // constructor
    private LotoDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized LotoDatabase getInstance() {
        if (lotoDatabase == null) {
            lotoDatabase = new LotoDatabase();
        }
        return lotoDatabase;
    }

    // special methods
    public static void loadResource() {
        List<Single> lotoSingles = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(LOTO_PATH).toURI());
            lotoSingles = LOADER.loadData(path);
            System.out.println(LOTO_DATABASE);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        List<Sample> lotoSamples = new ArrayList<>();
        Integer lastLotoIndex = 0;

        for (Single item : lotoSingles) {

            Sample sample = new Sample();
            lastLotoIndex++;

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
            Integer[] intex = new Integer[6];

            intex[0] = sample.getIntex1();
            intex[1] = sample.getIntex2();
            intex[2] = sample.getIntex3();
            intex[3] = sample.getIntex4();
            intex[4] = sample.getIntex5();
            intex[5] = sample.getIntex6();

            Integer[] codex = {0, 0, 0, 0, 0};
            Integer[] decada = new Integer[6];
            StringBuilder string = new StringBuilder();

            for (int i = 0; i < 6; i++) {
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
            sample.setIndex(lastLotoIndex);

            lotoSamples.add(sample);
        }

        LOTODB.setLotoList(lotoSamples);
        System.out.println(lotoSamples);
    }

    // getters & setters
    public List<Sample> getLotoList() {
        return lotoList;
    }

    public void setLotoList(List<Sample> lotoList) {
        this.lotoList = lotoList;
    }
}
