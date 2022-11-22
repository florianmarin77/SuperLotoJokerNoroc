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
import static com.lafi.sljn.internal.database.Database.SUPERDB;
import static com.lafi.sljn.internal.message.CommonMessages.SUPER_DATABASE;
import static com.lafi.sljn.internal.message.CommonMessages.SUPER_PATH;

public class SuperDatabase {

    // Singleton pattern
    private static SuperDatabase database = null;

    // database resources
    private List<Sample> samples = new ArrayList<>();

    private List<Integer> absoluteFrequencies = new ArrayList<>();
    private List<Integer> relativeFrequencies = new ArrayList<>();

    // constructor
    private SuperDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized SuperDatabase getInstance() {
        if (database == null) {
            database = new SuperDatabase();
        }
        return database;
    }

    // special methods
    public static void loadResource() {
        List<Single> singles = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
            singles = LOADER.loadData(path);
            System.out.println(SUPER_DATABASE);
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
            sample.setIndex(lastIndex);

            samples.add(sample);
        }

        SUPERDB.setSamples(samples);
    }

    // getters & setters
    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    public List<Integer> getAbsoluteFrequencies() {
        return absoluteFrequencies;
    }

    public void setAbsoluteFrequencies(List<Integer> absoluteFrequencies) {
        this.absoluteFrequencies = absoluteFrequencies;
    }

    public List<Integer> getRelativeFrequencies() {
        return relativeFrequencies;
    }

    public void setRelativeFrequencies(List<Integer> relativeFrequencies) {
        this.relativeFrequencies = relativeFrequencies;
    }
}
