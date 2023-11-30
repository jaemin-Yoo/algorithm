import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited[start] = 0
    q = deque()
    q.append(start)
    while q:
        v = q.popleft()
        if v == k:
            print(visited[v])
            break
        
        if 0<v*2<100001 and visited[v*2] == -1:
            visited[v*2] = visited[v]
            q.append(v*2)
            
        if 0<=v-1<100001 and visited[v-1] == -1:
            visited[v-1] = visited[v] + 1
            q.append(v-1)
            
        if 0<=v+1<100001 and visited[v+1] == -1:
            visited[v+1] = visited[v] + 1
            q.append(v+1)

n, k = map(int, input().split())
visited = [-1 for _ in range(100001)]
bfs(n)