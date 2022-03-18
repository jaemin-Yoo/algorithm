import sys
from collections import deque
input = sys.stdin.readline
m, n = map(int, input().strip().split())

def bfs(q):
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<m and graph[a][b] == 0:
                q.append((a, b))
                graph[a][b] = 1
                dist[a][b] = dist[x][y] + 1
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                return -1
    return dist[x][y]
                
        
        

graph = []
dist = [[0 for _ in range(m)] for _ in range(n)]
q = deque()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    graph.append(list(map(int, input().strip().split())))
    for j in range(m):
        if graph[i][j] == 1:
            q.append((i, j))

print(bfs(q))