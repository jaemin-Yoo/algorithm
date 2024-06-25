package boj;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(c, 1);

        ArrayList<Integer> sushiList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sushi = sc.nextInt();
            sushiList.add(sushi);
        }

        int count = 1;
        for (int i = 0; i < k; i++) {
            int sushi = sushiList.get(i);
            if (map.containsKey(sushi)) {
                map.put(sushi, map.get(sushi) + 1);
            } else {
                map.put(sushi, 1);
                count++;
            }
        }

        int maxCount = count;
        for (int i = 0; i < n; i++) {
            int headSushi = sushiList.get(i);
            if (map.get(headSushi) == 1) {
                map.remove(headSushi);
                count--;
            } else {
                map.put(headSushi, map.get(headSushi) - 1);
            }

            int tailSushi = sushiList.get((i + k) % n);
            if (map.containsKey(tailSushi)) {
                map.put(tailSushi, map.get(tailSushi) + 1);
            } else {
                map.put(tailSushi, 1);
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
}