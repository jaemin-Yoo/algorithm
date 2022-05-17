import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x, y, s = q.popleft()
        
        if x == n-1 and y == m-1:
            return visited[s][x][y]
        
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<m:
                if graph[a][b] == 1 and s == 0:
                    visited[1][a][b] = visited[0][x][y] + 1
                    q.append((a, b, 1))
                elif graph[a][b] == 0 and visited[s][a][b] == 0:
                    visited[s][a][b] = visited[s][x][y] + 1
                    q.append((a, b, s))
    return -1
        
n, m = map(int, input().split())
graph = []
visited = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(2)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

visited[0][0][0] = 1
print(bfs((0, 0, 0)))