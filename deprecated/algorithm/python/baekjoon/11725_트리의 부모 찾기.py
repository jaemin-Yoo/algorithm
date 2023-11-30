import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    for node in graph[start]:
        visited[node] = 1
        q.append(node)
    while q:
        v = q.pop()
        for node in graph[v]:
            if visited[node] == 0:
                visited[node] = v
                q.append(node)
            

n = int(input())
graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]
visited[1] = 1
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)
for i in range(2, n+1):
    print(visited[i])