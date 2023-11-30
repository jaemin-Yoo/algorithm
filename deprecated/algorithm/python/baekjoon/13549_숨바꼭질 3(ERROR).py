import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        time = 0
        for i in range(3):
            if i == 2:
                pos = v * dv[i]
                time = 0
            else:
                pos = v + dv[i]
                time = 1
            
            if 0<=pos<100001:
                if dist[pos] > dist[v] + time or visited[pos] == 0:
                    dist[pos] = dist[v] + time
                    q.append(pos)
                visited[pos] = 1
        if visited[k] == 1:
            break

n, k = map(int, input().split())
visited = [0 for _ in range(100001)]
dist = [0 for _ in range(100001)]
dv = [-1, 1, 2]
bfs(n)
print(dist[k])