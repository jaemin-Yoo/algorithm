import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def dfs(n, w):
    for node, weight in graph[n]:
        if visited[node] == 0:
            cw = weight + w
            visited[node] = cw
            dfs(node, cw)

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    p, c, w = map(int, input().split())
    graph[p].append((c, w))
    graph[c].append((p, w))
    
visited = [0 for _ in range(n+1)]
visited[1] = -1
dfs(1, 0)

mv = max(visited)
start = visited.index(max(visited))

visited = [0 for _ in range(n+1)]
visited[start] = -1
dfs(start, 0)
print(max(visited))