package softeer.level1;

import java.io.*;
import java.util.*;

public class 연탄배달의시작 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mn = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (mn > diff) {
                mn = diff;
                cnt = 1;
            } else if (mn == diff) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
