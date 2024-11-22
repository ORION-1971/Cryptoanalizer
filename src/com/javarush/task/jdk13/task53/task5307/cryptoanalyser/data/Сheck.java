package com.javarush.task.jdk13.task53.task5307.cryptoanalyser.data;

public class Сheck {

    public Boolean check(String testString) {

        String[] substrings = testString.split(" |\n");
        boolean bool = true;
        for (int i = 0; i < substrings.length; i++) {
            char[] temp = substrings[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                if (j < (temp.length - 1)) {
                    if (temp[j] == '(' || temp[j] == ',' || temp[j] == '?' || temp[j] == '!' || temp[j] == ':') {
                        bool = false;
                        break;
                    }
                }
            }
            if (substrings[i].length() > 30) {
                bool = false;
                break;
            }
        }
        return bool;
    }
}
