package softeer.level1;

import java.io.*;
import java.util.*;

public class 근무시간 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hour = 0;
        int min = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");
            int sHour = Integer.parseInt(start[0]);
            int sMin = Integer.parseInt(start[1]);
            int eHour = Integer.parseInt(end[0]);
            int eMin = Integer.parseInt(end[1]);
            hour += eHour - sHour;
            min += eMin - sMin;
        }
        System.out.println(hour * 60 + min);
    }
}