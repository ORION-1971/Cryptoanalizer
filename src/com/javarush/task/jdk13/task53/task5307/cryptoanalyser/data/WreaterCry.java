package com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static com.javarush.task.jdk13.task53.task5307.cryptoanalyser.CryptoAnalyzer.scanner;
import static com.javarush.task.jdk13.task53.task5307.cryptoanalyser.CryptoAnalyzer.utf8;

public class WreaterCry {

    public void endsOfMethods(char[] newTextChars) {

        System.out.println("Введите адрес для создания файла расшифровки");
        String newFileAdress = scanner.next();
        while (!newFileAdress.endsWith(".txt"))
        {
            System.out.println("Ошибка! Новый файл должен быть в формате .txt. Введи снова или введите exit для выхода.");
            newFileAdress = scanner.next();
            if (newFileAdress.equalsIgnoreCase("exit")) break;
        }
        if (newFileAdress.equalsIgnoreCase("exit")) return;
        String newTextString = new String(newTextChars);
        try {
            Path newFile = Path.of(newFileAdress);
            Files.createFile(newFile);
            Files.writeString(newFile, newTextString, utf8);
            System.out.println("Создан новый файл по адресу " + newFileAdress);
        } catch (IOException e) {
            System.out.println("Ошибка! Не удалось создать файл по адресу " + newFileAdress);
        }
    }
}
