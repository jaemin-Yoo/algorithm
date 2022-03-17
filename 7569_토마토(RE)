import sys
from collections import deque
input = sys.stdin.readline

def bfs(q):
    while q:
        x, y, z = q.popleft()
        for i in range(6):
            a = x + dx[i]
            b = y + dy[i]
            c = z + dz[i]
            
            if 0<=a<h and 0<=b<n and 0<=c<m and graph[a][b][c] == 0:
                q.append((a, b, c))
                graph[a][b][c] = 1
                dist[a][b][c] = dist[x][y][z] + 1
                
    for k in range(h):
        for i in range(n):
            for j in range(m):
                if graph[k][i][j] == 0:
                    return -1
    return dist[x][y][z]
        
m, n, h = map(int, input().strip().split())
dist = [[] for _ in range(h)]
graph = [[] for _ in range(h)]

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]
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