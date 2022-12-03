package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Set<String> lines = CorpusReader.getLinesFromFile("corpus.txt");

//        lines.forEach(System.out::println);

        // Простое задание: посчитать частоту вхождения буквы английского (26) алфавита в корпус текста.
        // Обойти каждый элемент Set
        // Взять i-ый символ строки
        // Определить - это символ английского алфавита?
        // Занести его в статистику <------

        // Поделить сколько раз встретился символ на общее число символов английского алфавита в тексте
        // Отсортировать результаты в порядке убывания частоты, вывести на экран в этом порядке
        // Сложное задание: символ = 1-грамма. Посчитать тоже самое для 1, 2, 3, 4, 5 -грамм
        // Частоты для n-грамм считаются по общему количеству таких же n-грамм.
        // Выводите первые 30 n-грамм по частоте встречаемости

        System.out.println("\n-= Простое задание =-\n");
        lines.stream()
                .map(word -> word.replaceAll("[^A-Za-z]+", "").toLowerCase())
                .flatMap(line -> Stream.of(line.split("")))
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach( entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


        System.out.println("\n-= Сложное задание =-");
        for (int i=1; i <= 5; i++) {
            System.out.println("\n" + i + "-Grams:");
            nGrams(lines, i);
        }


    }

    public static void nGrams(Set<String> lines, int n) {
        lines.stream()
                .map(word -> word.replaceAll("[^A-Za-z ]+", "").toLowerCase())
                .flatMap(line -> IntStream.range(0, line.length() - n + 1).mapToObj(i -> line.substring(i, i + n)))
                .filter(line -> !line.contains(" "))
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(30)
                .forEach( entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

}