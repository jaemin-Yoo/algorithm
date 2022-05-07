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
            if 0<=a<n and 0<=b<n and graph[a][b] != 0 and visited[a][b] == 0:
                visited[a][b] = 1
                q.append((a, b))
                cnt += 1
    return cnt

n = int(input())

graph = [[0 for _ in range(n)] for _ in range(n)]
visited = [[0 for _ in range(n)] for _ in range(n)]
dist = [[0 for _ in range(n)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    row = input().rstrip()
    for j, v in enumerate(row):
        graph[i][j] = int(v)
        
arr = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and visited[i][j] == 0:
            visited[i][j] = 1
            arr.append(bfs((i, j)))
arr.sort()
print(len(arr))
for result in arr:
    print(result)