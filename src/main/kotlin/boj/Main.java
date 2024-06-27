package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int v;
            if (cmd.equals("all") || cmd.equals("empty")) {
                v = -1;
            } else {
                v = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "add":
                    if (!arr.contains(v)) {
                        arr.add(v);
                    }
                    break;
                case "remove":
                    arr = remove(arr, v);
                    break;
                case "check":
                    if (arr.contains(v)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    if (arr.contains(v)) {
                        arr = remove(arr, v);
                    } else {
                        arr.add(v);
                    }
                    break;
                case "all":
                    arr.clear();
                    for (int j = 1; j < 21; j++) {
                        arr.add(j);
                    }
                    break;
                case "empty":
                    arr.clear();
                    break;
            }
        }
        System.out.println(sb);
    }

    private static ArrayList<Integer> remove(ArrayList<Integer> arr, int v) {
        ArrayList<Integer> newArr = new ArrayList<>();
        for (int data : arr) {
            if (data != v) {
                newArr.add(data);
            }
        }
        return newArr;
    }
}