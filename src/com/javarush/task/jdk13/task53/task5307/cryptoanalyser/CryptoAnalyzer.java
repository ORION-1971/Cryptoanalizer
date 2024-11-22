package com.javarush.task.jdk13.task53.task5307.cryptoanalyser;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data.*;


public class CryptoAnalyzer {
    public static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' ', '.', ',', '?', '!', ':', '-', '"', '\''};
    public static Scanner scanner = new Scanner(System.in);
    public static Charset utf8 = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        Cypher cypher = new Cypher();
        Decypher decypher = new Decypher();
        String text = "Что необходимо сделать?: \n1. Зашифровать текст\n2. Дешифровать текст\n3. Дешифровка текста методом \"brute force\"\nДля выхода введите \"exit\"";
        System.out.println(text);
        String choose = scanner.nextLine();
        while (!choose.equals("1") && !choose.equals("2") && !choose.equals("3") && !choose.equalsIgnoreCase("exit")) {
            System.out.println("Неверный выбор операции.");
            choose = scanner.nextLine();
        }
        if (choose.equals("1")) {
            cypher.encryption();
        } else if (choose.equals("2")) {
            decypher.decoding();
        } else if (choose.equals("3")) {
            decypher.bruteForce();
        } else if (choose.equalsIgnoreCase("exit")) {
            return;
        }
    }
}