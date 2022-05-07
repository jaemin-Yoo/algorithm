import sys
from collections import deque
input = sys.stdin.readline

def bfs(q):
    while q:
        a, b, c = q.popleft()
        if a - 1 >= 0:
            if graph[a-1][b][c] == 0:
                q.append((a - 1, b, c))
                graph[a-1][b][c] = 1
                dist[a-1][b][c] = dist[a][b][c] + 1
        if a + 1 < h:
            if graph[a+1][b][c] == 0:
                q.append((a + 1, b, c))
                graph[a+1][b][c] = 1
                dist[a+1][b][c] = dist[a][b][c] + 1
        if b - 1 >= 0:
            if graph[a][b-1][c] == 0:
                q.append((a, b - 1, c))
                graph[a][b-1][c] = 1
                dist[a][b-1][c] = dist[a][b][c] + 1
        if b + 1 < n:
            if graph[a][b+1][c] == 0:
                q.append((a, b+1, c))
                graph[a][b+1][c] = 1
                dist[a][b+1][c] = dist[a][b][c] + 1
        if c - 1 >= 0:
            if graph[a][b][c-1] == 0:
                q.append((a, b, c-1))
                graph[a][b][c-1] = 1
                dist[a][b][c-1] = dist[a][b][c] + 1
        if c + 1 < m:
            if graph[a][b][c+1] == 0:
                q.append((a, b, c+1))
                graph[a][b][c+1] = 1
                dist[a][b][c+1] = dist[a][b][c] + 1
                
    for k in range(h):
        for i in range(n):
            for j in range(m):
                if graph[k][i][j] == 0:
                    return -1
    return dist[a][b][c]
        
m, n, h = map(int, input().strip().split())
dist = [[] for _ in range(h)]
graph = [[] for _ in range(h)]
for k in range(h):
    for i in range(n):
        a = list(map(int, input().split()))
        graph[k].append(a)
        
        b = []
        for j in range(m):
            b.append(0)
        dist[k].append(b)
        
q = deque()
for k in range(h):
    for i in range(n):
        for j in range(m):
            if graph[k][i][j] == 1:
                q.append((k, i, j))
print(bfs(q))