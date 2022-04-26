from re import L
import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    global n, m
    
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<m and 0<=b<n and graph[a][b] == 1:
                graph[a][b] = 0
                q.append((a, b))         
        
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())
    
    graph = [[0 for _ in range(n)] for _ in range(m)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1
    
    cnt = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                cnt += 1
                bfs((i, j))
    print(cnt)