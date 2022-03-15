import sys
from collections import deque

def bfs(start):
    visited = [0] * 10000
    visited[start] = 1
    q = deque()
    q.append((start, ''))
    while q:
        v, temp = q.popleft()
        for i in range(4):
            n, ds = calcul(v, i)
            s = temp + ds
            if visited[n] == 0:
                visited[n] = 1
                q.append((n, s))
                if n == b:
                    print(s)
                    return 0
        
def calcul(n, i):
    if i == 0:
        return (n * 2) % 10000, "D"
    elif i == 1:
        if n == 0:
            return 9999, 'S'
        else:
            return n - 1, 'S'
    elif i == 2:
        return (n % 1000) * 10 + (n // 1000), 'L'
    else:
        return (n // 10) + (n % 10) * 1000, 'R'
    
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    a, b = map(int, input().strip().split())
    bfs(a)