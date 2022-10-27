package com.lafi.sljn.sample.loader;


import com.lafi.sljn.sample.model.Sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SampleLoader {

    public List<Sample> loadData(Path path) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        List<Sample> result = new ArrayList<>();
        for (String item : data) {
            List<String> itemData = Pattern.compile(",")
                    .splitAsStream(item).collect(Collectors.toList());
            result.add(new Sample(itemData.get(0), itemData.get(1), itemData.get(2), itemData.get(3), itemData.get(4), itemData.get(5), itemData.get(6)));
        }

        return result;
    }

}
