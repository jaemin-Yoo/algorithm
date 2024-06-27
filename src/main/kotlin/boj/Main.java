package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = h;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                        rank += 1;
                    }
                }
            }
            sb.append(rank);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}