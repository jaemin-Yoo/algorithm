import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        for i in graph[v]:            
            if visited[i] == 0:
                visited[i] = 1
                q.append(i)
                dist[i] = dist[v] + 1
    return sum(dist)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

min_cnt = 1e9
result = 0
for i in range(1, n+1):
    visited = [0 for _ in range(n+1)]
    dist = [0 for _ in range(n+1)]
    visited[i] = 1
    
    cnt = bfs(i)
    if min_cnt > cnt:
        min_cnt = cnt
        result = i
print(result)
        