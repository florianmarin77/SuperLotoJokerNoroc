package com.lafi.sljn.sample.loaders;

import com.lafi.sljn.sample.models.Single;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SingleLoader implements Loader<Single> {

    @Override
    public List<Single> loadData(Path path) {
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        List<Single> result = new ArrayList<>();
        int k = 0;

        for (String item : data) {
            List<String> itemData = Pattern.compile(",").splitAsStream(item).collect(Collectors.toList());

            Single single = new Single();
            k++;

            // DATEX ready
            single.setDatex(itemData.get(0));

            // INTEX ready
            single.setIntex1(itemData.get(1));
            single.setIntex2(itemData.get(2));
            single.setIntex3(itemData.get(3));
            single.setIntex4(itemData.get(4));
            single.setIntex5(itemData.get(5));
            single.setIntex6(itemData.get(6));

            // preparing CODEX
            Integer[] intex = new Integer[6];
            intex[0] = Integer.valueOf(single.getIntex1());
            intex[1] = Integer.valueOf(single.getIntex2());
            intex[2] = Integer.valueOf(single.getIntex3());
            intex[3] = Integer.valueOf(single.getIntex4());
            intex[4] = Integer.valueOf(single.getIntex5());
            intex[5] = Integer.valueOf(single.getIntex6());

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
            single.setCodex(string.toString());

            // INDEX ready
            single.setIndex(Integer.toString(k));

            System.out.println(single);
            result.add(single);
        }

        return result;
    }
}
