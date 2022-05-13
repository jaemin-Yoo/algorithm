import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        for i in range(8):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<h and 0<=b<w and visited[a][b] == 0 and graph[a][b] == 1:
                q.append((a, b))
                visited[a][b] = 1

while True:
    w, h = map(int, input().split())
    if (w, h) == (0, 0):
        break
    
    graph = []
    visited = [[0 for _ in range(w)] for _ in range(h)]
    dx = [-1, 0, 1, 1, 1, 0, -1, -1]
    dy = [-1, -1, -1, 0, 1, 1, 1, 0]
    for _ in range(h):
        graph.append(list(map(int, input().split())))
    
    cnt = 0
    for i in range(h):
        for j in range(w):
            if visited[i][j] == 0 and graph[i][j] == 1:
                bfs((i, j))
                cnt += 1
    print(cnt)