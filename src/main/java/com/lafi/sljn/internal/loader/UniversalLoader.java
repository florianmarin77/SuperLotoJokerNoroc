package com.lafi.sljn.internal.loader;

import com.lafi.sljn.internal.model.Sample;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniversalLoader {

    /**
     * @param path Calea către fișier (.txt)
     * @param isJoker Dacă este true, ultimul număr va fi tratat ca "Special"
     */
    public List<Sample> loadFromFile(Path path, boolean isJoker) {
        List<Sample> samples = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            int currentIndex = 1;

            for (String line : lines) {
                if (line == null || line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                String date = parts[0];

                // Transformăm restul părților în listă de numere
                List<Integer> allNumbers = Arrays.stream(parts)
                        .skip(1)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                List<Integer> mainNumbers;
                Integer specialNumber = null;

                if (isJoker && allNumbers.size() >= 6) {
                    // Pentru Joker: primele 5 sunt principale, al 6-lea e Jokerul
                    mainNumbers = allNumbers.subList(0, 5);
                    specialNumber = allNumbers.get(5);
                } else {
                    // Pentru Loto/Super: toate sunt principale
                    mainNumbers = allNumbers;
                }

                samples.add(new Sample(date, mainNumbers, specialNumber, currentIndex++));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la procesarea fisierului " + path.getFileName() + ": " + e.getMessage());
        }
        return samples;
    }
}