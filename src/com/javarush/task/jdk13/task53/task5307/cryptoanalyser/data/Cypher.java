package com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data;

import static com.javarush.task.jdk13.task53.task5307.cryptoanalyser.CryptoAnalyzer.*;

public class Cypher {


    public void encryption() {
        ReaderCry readerCry = new ReaderCry();
        WreaterCry wreaterCry = new WreaterCry();

        char[] origTextChars = readerCry.startOfMethods();
        if (origTextChars == null) {
            return;
        }
        char[] encryptTextChars = new char[origTextChars.length];
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        for (int i = 0; i < origTextChars.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {

                if (origTextChars[i] == alphabet[j]) {

                    int tmp = j + key;
                    while ((tmp) >= alphabet.length) {
                        tmp = tmp - alphabet.length;
                    }
                    encryptTextChars[i] = alphabet[tmp];
                    break;
                }
            }

            if (encryptTextChars[i] == 0) {
                encryptTextChars[i] = origTextChars[i];
            }
        }
        wreaterCry.endsOfMethods(encryptTextChars);
    }
}