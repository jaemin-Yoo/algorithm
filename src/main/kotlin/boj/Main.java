package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }

            if (isValid(password)) {
                sb.append(String.format("<%s> is acceptable.\n", password));
            } else {
                sb.append(String.format("<%s> is not acceptable.\n", password));
            }
        }
        System.out.println(sb);
    }

    private static boolean isValid(String word) {
        char prev = ' ';
        int vowelCnt = 0;
        int consonantCnt = 0;
        boolean containsVowel = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prev && c != 'e' && c != 'o') {
                return false;
            }
            prev = c;

            boolean isVowel = false;
            for (char vowel : vowels) {
                if (c == vowel) {
                    isVowel = true;
                    containsVowel = true;
                    break;
                }
            }
            if (isVowel) {
                vowelCnt++;
                consonantCnt = 0;
            } else {
                consonantCnt++;
                vowelCnt = 0;
            }

            if (vowelCnt == 3 || consonantCnt == 3) {
                return false;
            }
        }

        return containsVowel;
    }
}