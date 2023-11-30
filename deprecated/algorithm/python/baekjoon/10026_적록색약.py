import sys
from collections import deque
input = sys.stdin.readline

def bfs(s, start):
    global n
    
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<n and not visited[a][b] and graph[a][b] == s:
                visited[a][b] = True
                q.append((a,b))
                
    

n = int(input())
graph = [["" for _ in range(n)] for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    arr = input().strip()
    for j, v in enumerate(arr):
        graph[i][j] = v

cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(graph[i][j], (i,j))
            cnt += 1
print(cnt, end=" ")

visited = [[False for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == "G":
            graph[i][j] = "R"

cnt = 0       
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(graph[i][j], (i,j))
            cnt += 1
print(cnt)