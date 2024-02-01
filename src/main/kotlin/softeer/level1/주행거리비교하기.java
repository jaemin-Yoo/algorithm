package softeer.level1;

import java.io.*;
import java.util.*;

public class 주행거리비교하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String result = a > b ? "A" : a < b ? "B" : "same";
        System.out.println(result);
    }
}