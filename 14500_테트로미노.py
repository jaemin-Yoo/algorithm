import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited = [start]
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<m and (a, b) not in visited and len(visited) < 4:
                visited.append((a, b))
                q.append((a, b))

n, m = map(int, input().split())
graph = []
result_list = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n):
    graph.append(list(map(int, input().split())))
    
for i in range(n):
    for j in range(m):
        bfs((i, j))