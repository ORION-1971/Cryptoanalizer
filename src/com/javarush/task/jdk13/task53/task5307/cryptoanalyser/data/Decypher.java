package com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data;

import static com.javarush.task.jdk13.task53.task5307.cryptoanalyser.CryptoAnalyzer.*;

public class Decypher {

    ReaderCry readerCry = new ReaderCry();
    WreaterCry wreaterCry = new WreaterCry();

    public void decoding() {

        char[] origTextChars = readerCry.startOfMethods();
        if (origTextChars == null) {
            return;
        }
        char[] decodeTextChars = new char[origTextChars.length];
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        for (int i = 0; i < origTextChars.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (origTextChars[i] == alphabet[j]) {
                    int tmp = j - key;
                    while ((tmp) < 0) {
                        tmp = tmp + alphabet.length;
                    }
                    decodeTextChars[i] = alphabet[tmp];
                    break;
                }
            }
            if (decodeTextChars[i] == 0) {
                decodeTextChars[i] = origTextChars[i];
            }
        }
        wreaterCry.endsOfMethods(decodeTextChars);
    }

    public void bruteForce() {

        char[] origTextChars = readerCry.startOfMethods();
        if (origTextChars == null) {
            return;
        }
        char[] decodeTextChars = new char[origTextChars.length];
        char[] testDecodeTextChars = new char[origTextChars.length];
        int key = 0;
        while (key < alphabet.length) {
            key++;

            for (int i = 0; i < origTextChars.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (origTextChars[i] == alphabet[j]) {
                        int tmp = j - key;
                        if (tmp < 0) {
                            tmp = tmp + alphabet.length;
                        }
                        testDecodeTextChars[i] = alphabet[tmp];
                        break;
                    }
                }
            }
            String testDecodeTextString = new String(testDecodeTextChars);


            Сheck сheck = new Сheck();
            boolean ch = сheck.check(testDecodeTextString);
            if (!ch) continue;

            if (ch) {
                decodeTextChars = testDecodeTextChars;

                for (int i = 0; i < decodeTextChars.length; i++) {
                    if (decodeTextChars[i] == 0)
                        decodeTextChars[i] = origTextChars[i];
                }
                System.out.println("Ключ был равен " + key);
                break;
            }
        }
        wreaterCry.endsOfMethods(decodeTextChars);
    }
}
