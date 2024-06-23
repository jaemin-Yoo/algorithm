package programmers.basic;

import java.util.Scanner;

public class PrintChangeUpperLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] str = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isUpperCase(c)) {
                str[i] = Character.toLowerCase(c);
            } else {
                str[i] = Character.toUpperCase(c);
            }
        }
        System.out.println(str);
    }
}
