package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Counter {
    public static LinkedHashMap<String, Long> countWords(String filename) {
        try {
            Path path = Paths.get("src/main/resources/" + filename);
            String input = String.join(" ", Files.readAllLines(path)).trim();
            return input.isEmpty() ? new LinkedHashMap<>() : Arrays.stream(input.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
