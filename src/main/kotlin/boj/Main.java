package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] medals = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medals[country] = new int[]{gold, silver, bronze};
        }

        int rank = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i != k) {
                if ((medals[i][0] > medals[k][0]) || (medals[i][0] == medals[k][0] && medals[i][1] > medals[k][1]) || (medals[i][0] == medals[k][0] && medals[i][1] == medals[k][1] && medals[i][2] > medals[k][2])) {
                    rank++;
                }
            }
        }
        System.out.println(rank);
    }
}