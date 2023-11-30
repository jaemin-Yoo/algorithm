import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<n and visited[a][b] == 0:
                visited[a][b] = 1
                q.append((a, b))
        

n = int(input())
graph = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
for _ in range(n):
    graph.append(list(map(int, input().split())))

result = 0
for k in range(101):
    visited = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] <= k:
                visited[i][j] = 1
    
    cnt = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                bfs((i, j))
                cnt += 1
    result = max(cnt, result)
print(result)