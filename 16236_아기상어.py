import sys
from collections import deque

def bfs(p):
    global size, cnt, result
    visited = [[0] * n for _ in range(n)]
    dist = [[0] * n for _ in range(n)]
    
    eat = []
    visited[p[0]][p[1]] = 1
    q = deque()
    q.append(p)
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx >= 0 and ny >= 0 and nx < n and ny < n and visited[nx][ny] == 0 and graph[nx][ny] <= size:
                q.append((nx, ny))
                visited[nx][ny] = 1
                dist[nx][ny] = dist[x][y] + 1
                
                if graph[nx][ny] < size and graph[nx][ny] != 0:
                    eat.append((nx, ny, dist[nx][ny]))
                    
    if eat != []:
        eat = sorted(eat, key = lambda x: (x[2], x[0], x[1]))
        
        graph[eat[0][0]][eat[0][1]] = 0
        cnt += 1
        if size == cnt:
            cnt = 0
            size += 1
        result += eat[0][2]
        bfs((eat[0][0], eat[0][1]))
                    
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().strip().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            graph[i][j] = 0
            start = (i, j)

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]
size = 2
cnt = 0
result = 0
bfs(start)
print(result)