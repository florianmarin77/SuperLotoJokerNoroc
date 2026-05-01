package com.lafi.sljn.internal.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    private final String datex;
    private final List<Integer> intex;   // Cele 5 sau 6 numere principale
    private final Integer special;       // Jokerul (sau null pentru Loto/Super)
    private final String codex;
    private final int index;

    public Sample(String datex, List<Integer> mainNumbers, Integer special, int index) {
        this.datex = datex;
        this.intex = new ArrayList<>(mainNumbers);
        this.special = special;
        this.index = index;
        this.codex = calculateCodex(mainNumbers);
    }

    private String calculateCodex(List<Integer> numbers) {
        int[] decades = new int[5];
        for (int num : numbers) {
            int d = num / 10;
            if (d >= 0 && d < 5) decades[d]++;
        }
        List<Integer> counts = new ArrayList<>();
        for (int count : decades) {
            if (count > 0) counts.add(count);
        }
        counts.sort(Collections.reverseOrder());
        return counts.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // Getters
    public String getDatex() {
        return datex;
    }

    public List<Integer> getIntexList() {
        return intex;
    }

    public String getIntexString() {
        return intex.toString();
    }

    public Integer getSpecial() {
        return special;
    }

    public String getCodex() {
        return codex;
    }

    public int getIndex() {
        return index;
    }
}