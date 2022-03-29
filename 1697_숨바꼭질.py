import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        if v == k:
            print(dist[v])
            break
        
        for i in range(3):
            if dx[i] == 0:
                x = v * 2
            else:
                x = v + dx[i]
            
            if 0<=x<=100000 and visited[x] == 0:
                visited[x] = 1
                dist[x] = dist[v]+1
                q.append(x)

n, k = map(int, input().split())
visited = [0 for _ in range(100001)]
dist = [0 for _ in range(100001)]
dx = [-1, 1, 0]
visited[n] = 1
bfs(n)