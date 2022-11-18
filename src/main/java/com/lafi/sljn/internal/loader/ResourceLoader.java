package com.lafi.sljn.internal.loader;

import com.lafi.sljn.internal.model.Single;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ResourceLoader {

    public List<Single> loadData(Path path) {
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        List<Single> singles = new ArrayList<>();

        for (String item : data) {
            List<String> itemData = Pattern.compile(",").splitAsStream(item).collect(Collectors.toList());

            Single single = new Single();

            // DATEX ready
            single.setDatex(itemData.get(0));

            // INTEX ready
            single.setIntex1(itemData.get(1));
            single.setIntex2(itemData.get(2));
            single.setIntex3(itemData.get(3));
            single.setIntex4(itemData.get(4));
            single.setIntex5(itemData.get(5));
            single.setIntex6(itemData.get(6));

            singles.add(single);
        }

        return singles;
    }
}
