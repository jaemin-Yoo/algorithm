import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        x, y = q.popleft()
        
        for i in range(8):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<n and visited[a][b] == 0:
                q.append((a, b))
                visited[a][b] = visited[x][y] + 1
                
                # for row in visited:
                #     print(*row)
                
                
                # print()
                
                
                if a == ex and b == ey:
                    return visited[a][b]
    
    return 1

t = int(input())

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]
for _ in range(t):
    n = int(input())
    visited = [[0 for _ in range(n)] for _ in range(n)]
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())
    
    visited[sx][sy] = 1
    print(bfs((sx, sy))-1)