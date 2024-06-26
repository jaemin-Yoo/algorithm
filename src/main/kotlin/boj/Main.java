package boj;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = 0;
        for (int i = 0; i < h; i += n + 1) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < w; i += m + 1) {
            b++;
        }
        System.out.println(a * b);
    }
}