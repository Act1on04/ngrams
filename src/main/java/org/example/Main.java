package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Set<String> lines = CorpusReader.getLinesFromFile("corpus.txt");

        lines.forEach(System.out::println);

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
    }
}