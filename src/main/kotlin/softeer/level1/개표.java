package softeer.level1;

import java.io.*;
import java.util.*;

public class 개표 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int fCnt = n / 5;
            int dCnt = n % 5;
            StringBuilder sb = new StringBuilder();
            sb.append("++++ ".repeat(fCnt));
            if (dCnt == 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("|".repeat(dCnt));
            System.out.println(sb);
        }
    }
}
