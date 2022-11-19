package com.lafi.sljn;

import com.lafi.sljn.internal.database.JokerDatabase;
import com.lafi.sljn.internal.database.LotoDatabase;
import com.lafi.sljn.internal.database.SuperDatabase;
import com.lafi.sljn.internal.loader.ResourceLoader;
import com.lafi.sljn.internal.model.Sample;
import com.lafi.sljn.internal.model.Single;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.lafi.sljn.internal.message.CommonMessages.*;

public class SuperLotoJokerNoroc {

    static final ResourceLoader LOADER = new ResourceLoader();

    static final SuperDatabase SUPERDB = SuperDatabase.getInstance();
    static final LotoDatabase LOTODB = LotoDatabase.getInstance();
    static final JokerDatabase JOKERDB = JokerDatabase.getInstance();


    public static void main(String[] args) {

        // SUPER database

        List<Single> superSingles = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(SUPER_PATH).toURI());
            superSingles = LOADER.loadData(path);
            System.out.println(SUPER_DATABASE);
        } catch (URISyntaxException exception) {
            exception.printStackTrace();
        }

        List<Sample> superSamples = new ArrayList<>();
        Integer lastSuperIndex = 0;

        for (Single item : superSingles) {

            Sample sample = new Sample();
            lastSuperIndex++;

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
            sample.setIndex(lastSuperIndex);

            superSamples.add(sample);
        }

        SUPERDB.setSuperList(superSamples);
        System.out.println(superSamples);

        // Loto database

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

        // Joker database

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
        System.out.println(jokerSamples);
    }
}
