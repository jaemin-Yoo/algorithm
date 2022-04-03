import sys
from collections import deque
import copy
input = sys.stdin.readline

def makeWall(cnt):
    if cnt == 3:
        bfs()
        return
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                makeWall(cnt + 1)
                graph[i][j] = 0

def bfs():
    q = copy.deepcopy(dq)
    test = copy.deepcopy(graph)
    visited = [[0 for _ in range(m)] for _ in range(n)]
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            a = x + dx[i]
            b = y + dy[i]
            if 0<=a<n and 0<=b<m and visited[a][b] == 0 and test[a][b] == 0:
                visited[a][b] = 1
                test[a][b] = 2
                q.append((a, b))
    
    cnt = 0
    for i in range(n):
        for j in range(m):
            if test[i][j] == 0:
                cnt += 1
    cntList.append(cnt)
                
        

n, m = map(int, input().split())
graph = []

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cntList = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

dq = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            dq.append((i, j))
            
makeWall(0)
print(max(cntList))