import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    count = 0
    q = deque()
    q.append(start)
    while q:
        node = q.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
                count += 1
                
    return count

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().strip().split())
    graph[a].append(b)
    graph[b].append(a)
    
visited[1] = True
print(bfs(1))