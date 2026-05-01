package com.lafi.sljn.internal.analysis;

import com.lafi.sljn.internal.model.Sample;

import java.util.*;

public class StatisticsEngine {

    public Map<Integer, Integer> calculateFrequency(List<Sample> data) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Sample s : data) {
            for (Integer num : s.getIntexList()) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }
        return new TreeMap<>(freqMap);
    }

    public Map<Integer, Integer> calculateSpecialFrequency(List<Sample> data) {
        Map<Integer, Integer> specialFreqMap = new HashMap<>();
        for (Sample s : data) {
            if (s.getSpecial() != null) {
                int joker = s.getSpecial();
                specialFreqMap.put(joker, specialFreqMap.getOrDefault(joker, 0) + 1);
            }
        }
        return new TreeMap<>(specialFreqMap);
    }

    public List<Map.Entry<Integer, Integer>> getSortedFrequencies(Map<Integer, Integer> frequencies) {
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencies.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return sortedList;
    }
}