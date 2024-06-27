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
        String type = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            set.add(name);
        }

        int answer = 0;
        switch (type) {
            case "Y":
                answer = set.size();
                break;
            case "F":
                answer = set.size() / 2;
                break;
            case "O":
                answer = set.size() / 3;
                break;
        }
        System.out.println(answer);
    }
}