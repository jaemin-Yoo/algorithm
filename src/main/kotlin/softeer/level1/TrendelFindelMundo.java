package softeer.level1;

import java.io.*;
import java.util.*;

public class TrendelFindelMundo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mn = 1001;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (mn > y) {
                result[0] = x;
                result[1] = y;
                mn = y;
            }
        }
        System.out.println(result[0] + " " +result[1]);
    }
}
