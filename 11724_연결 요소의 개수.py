import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        if visited[v] == 0:
            visited[v] = 1
            for i in graph[v]:
                q.append(i)

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0
for i in range(1, n+1):
    if visited[i] == 0:
        bfs(i)
        cnt += 1
print(cnt)