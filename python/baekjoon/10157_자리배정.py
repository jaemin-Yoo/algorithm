import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    global cnt
    
    q = deque()
    q.append((start))
    dir = 1
    while q:
        x, y = q.popleft()
        
        a = x + dx[dir]
        b = y + dy[dir]
        
        if a>=c or a<0 or b>=r or b<0 or graph[a][b] != 0:
            dir = (dir + 1) % 4
            a = x + dx[dir]
            b = y + dy[dir]
        
        if 0<=a<c and 0<=b<r and graph[a][b] == 0:
            if cnt == k:
                print("{} {}".format(a+1, b+1))
                return
            
            q.append((a,b))
            graph[a][b] = cnt
            
            cnt += 1
        
    print(0)

c, r = map(int, input().split())
k = int(input())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

graph = [[0 for _ in range(r)] for _ in range(c)]
graph[0][0] = 1
cnt = 2

if k == 1:
    print('1 1')
else:
    bfs((0, 0))