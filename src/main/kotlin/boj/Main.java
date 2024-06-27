package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                int h = Integer.parseInt(st.nextToken());
                arr.add(h);

                for (int k = 0; k < j; k++) {
                    if (arr.get(k) > h) {
                        cnt++;
                    }
                }
            }
            System.out.println(t + " " + cnt);
        }
    }
}