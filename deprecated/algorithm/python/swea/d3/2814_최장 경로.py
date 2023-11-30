from collections import deque

def dfs(node, dist):
    global cnt
    
    visited[node] = 1
    dist += 1
    if cnt < dist:
        cnt = dist
    
    for i in graph[node]:
        if visited[i] == 0:
            dfs(i, dist)
    visited[node] = 0

t = int(input())
for idx in range(1, t+1):
    n, m = map(int, input().split())
    
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    
    cnt = 0
    visited = [0 for _ in range(n+1)]
    for i in range(1, n+1):
        dfs(i, 0)
        
    print("#{} {}".format(idx, cnt))