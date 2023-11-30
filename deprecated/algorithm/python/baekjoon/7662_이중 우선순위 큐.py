import sys
import heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    
    q = []
    xq = []
    visited = [False for _ in range(k)]
    for i in range(k):
        c, n = input().strip().split()
        n = int(n)
        
        if c == 'I':
            heapq.heappush(q, (n, i))
            heapq.heappush(xq, (-n, i))
            visited[i] = True
        elif c == 'D':
            if n == -1:
                while q and not visited[q[0][1]]:
                    heapq.heappop(q)
                if q:
                    visited[q[0][1]] = False
                    heapq.heappop(q)
            elif n == 1:
                while xq and not visited[xq[0][1]]:
                    heapq.heappop(xq)
                if xq:
                    visited[xq[0][1]] = False
                    heapq.heappop(xq)

    while q and not visited[q[0][1]]:
        heapq.heappop(q)
    while xq and not visited[xq[0][1]]:
        heapq.heappop(xq)
    
    if not q or not xq:
        print("EMPTY")
    else:
        a = -xq[0][0]
        b = q[0][0]
        print("{} {}".format(a, b))