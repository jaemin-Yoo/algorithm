package softeer.level1;

import java.io.*;
import java.util.*;

public class 나무심기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mx = -10000;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    int mul = arr[i] * arr[j];
                    mx = Math.max(mx, mul);
                }
            }
        }
        System.out.println(mx);
    }
}
