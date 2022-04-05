import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited[start] = 1
    q = deque()
    q.append(start)
    while q:
        x = q.popleft()
        for i in range(6):
            a = x + dx[i]
                
            if a<=100:
                if ladder[a] != 0:
                    a = ladder[a]
                if snake[a] != 0:
                    a = snake[a]
                    
                if visited[a] == 0:
                    visited[a] = 1
                    q.append(a)
                    dist[a] = dist[x] + 1

n, m = map(int, input().split())

ladder = [0 for _ in range(101)]
for _ in range(n):
    x, y = map(int, input().split())
    ladder[x] = y

snake = [0 for _ in range(101)]
for _ in range(m):
    u, v = map(int, input().split())
    snake[u] = v
    
board = [0 for _ in range(101)]
visited = [0 for _ in range(101)]
dist = [0 for _ in range(101)]
dx = [1, 2, 3, 4, 5, 6]

a = 1
if ladder[a] != 0:
    a = ladder[a]
bfs(a)
print(dist[100])