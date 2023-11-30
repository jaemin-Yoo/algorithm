import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited = [start]
    dist[0][0] = 1
    
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        if (x, y) == (n-1, m-1):
            print(dist[x][y])
            return
        
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<m and (a, b) not in visited and graph[a][b] == 1:
                visited.append((a, b))
                q.append((a, b))
                dist[a][b] = dist[x][y] + 1
            
n, m = map(int, input().split())

graph = [[0 for _ in range(m)] for _ in range(n)]
dist = [[0 for _ in range(m)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    row = input().rstrip()
    for j, v in enumerate(row):
        graph[i][j] = int(v)
bfs((0,0))