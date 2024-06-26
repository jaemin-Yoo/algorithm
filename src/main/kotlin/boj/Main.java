package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c = 1;
        int v = 6;
        int answer = 1;
        while (n > c) {
            c += v;
            v += 6;
            answer++;
        }
        System.out.println(answer);
    }
}