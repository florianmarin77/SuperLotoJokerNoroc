package com.lafi.sljn.components.loaders;

import com.lafi.sljn.components.models.Sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SampleLoader implements Loader<Sample> {

    @Override
    public List<Sample> loadData(Path path) {
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        List<Sample> result = new ArrayList<>();
        Integer k = 0;

        for (String item : data) {
            List<String> itemData = Pattern.compile(",").splitAsStream(item).collect(Collectors.toList());

            Sample sample = new Sample();
            k++;

            // DATEX ready
            sample.setDatex(itemData.get(0));

            // INTEX ready
            sample.setIntex1(Integer.valueOf(itemData.get(1)));
            sample.setIntex2(Integer.valueOf(itemData.get(2)));
            sample.setIntex3(Integer.valueOf(itemData.get(3)));
            sample.setIntex4(Integer.valueOf(itemData.get(4)));
            sample.setIntex5(Integer.valueOf(itemData.get(5)));
            sample.setIntex6(Integer.valueOf(itemData.get(6)));

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
            sample.setIndex(k);

            result.add(sample);
        }

        return result;
    }
}
