package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }
            Arrays.sort(arr);

            String answer;
            int side1 = arr[0];
            int side2 = arr[1];
            int side3 = arr[2];
            if (side3 >= side1 + side2) {
                answer = "Invalid";
            } else if (side1 == side2 && side2 == side3) {
                answer = "Equilateral";
            } else if (side1 == side2 || side2 == side3) {
                answer = "Isosceles";
            } else {
                answer = "Scalene";
            }
            System.out.println(answer);
        }
    }
}