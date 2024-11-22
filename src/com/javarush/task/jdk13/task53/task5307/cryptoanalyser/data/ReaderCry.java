package com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.task.jdk13.task53.task5307.cryptoanalyser.CryptoAnalyzer.scanner;

public class ReaderCry {

    public char[] startOfMethods() {

        System.out.println("Введите адрес текстового файла для шифровки.");
        String origFileAdress;
        String origTextString = null;
        while (origTextString == null) {
            try {
                origFileAdress = scanner.nextLine();
                if (origFileAdress.equalsIgnoreCase("exit")) {
                    origTextString = origFileAdress;
                    break;

                } else {
                    Path origFile = Path.of(origFileAdress);
                    origTextString = Files.readString(origFile).toLowerCase();
                }
            } catch (IOException e) {
                System.out.println("Ошибка! Введи другой адрес файла, или введите \"exit\" для выхода.");
            }
        }
        if (origTextString.equalsIgnoreCase("exit")) {
            return null;
        } else {
            char[] origTextChars = origTextString.toCharArray();
            return origTextChars;
        }
    }
}
