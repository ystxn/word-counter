package org.example;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        String file = "text.txt";
        System.out.println("Count words for: " + file);
        LinkedHashMap<String, Long> count = Counter.countWords(file);
        System.out.println("Words: " + count.size());
        System.out.println("Counts: " + count);
    }
}
