package boj;

import java.util.*;

public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs(graph, n, m);
        System.out.println(result);
    }

    private static int bfs(int[][] graph, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});

        while (!q.isEmpty()) {
            int[] v = q.poll();
            int x = v[0];
            int y = v[1];
            int dist = v[2];
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int a = dx[i] + x;
                int b = dy[i] + y;
                if ((a >= 0 && a < n) && (b >= 0 && b < m) && graph[a][b] == 1 && !visited[a][b]) {
                    visited[a][b] = true;
                    q.add(new int[] {a, b, dist + 1});
                }
            }
        }
        return -1;
    }
}