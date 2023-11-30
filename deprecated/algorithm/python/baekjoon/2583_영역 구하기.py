import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<m and 0<=b<n and graph[a][b] == 0:
                q.append((a, b))
                graph[a][b] = 1
                cnt += 1    
    return cnt

m, n, k = map(int, input().split())
graph = [[0 for _ in range(n)] for _ in range(m)]
visited = [[0 for _ in range(n)] for _ in range(m)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(k):
    bx, by, tx, ty = map(int, input().split())
    for i in range(by, ty):
        for j in range(bx, tx):
            graph[i][j] = 1

result = []
cnt = 0
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            graph[i][j] = 1
            result.append(bfs((i, j)))
            cnt += 1

result.sort()
print(cnt)
print(*result)