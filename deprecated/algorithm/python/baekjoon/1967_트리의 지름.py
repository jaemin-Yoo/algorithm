import sys
input = sys.stdin.readline

def dfs(start):
    visited = [start]
    stack = [start]
    while stack:
        node = stack.pop()
        for i in graph[node]:    
            if i[0] not in visited:
                visited.append(i[0])
                stack.append(i[0])
                dist[i[0]] += dist[node] + i[1]    

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    p, c, w = map(int, input().split())
    graph[p].append((c, w))
    graph[c].append((p, w))
    
dist = [0 for _ in range(n+1)]
dfs(1)
mv = max(dist)
mi = dist.index(mv)

dist = [0 for _ in range(n+1)]
dfs(mi)
mv = max(dist)
print(mv)