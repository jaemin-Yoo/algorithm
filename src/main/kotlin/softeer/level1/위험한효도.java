package softeer.level1;

import java.io.*;
import java.util.*;

public class 위험한효도 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int time = 0;
        if (a >= d) {
            time += d;
        } else {
            time += d + (d / a) * b;
        }

        if (b >= d) {
            time += d;
        } else {
            time += d + (d / b) * a;
        }
        System.out.println(time);
    }
}
