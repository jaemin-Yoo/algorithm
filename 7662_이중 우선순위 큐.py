import sys
import heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    
    q = []
    xq = []
    visited = []
    for _ in range(k):
        c, n = input().strip().split()
        n = int(n)
        
        if c == 'I':
            heapq.heappush(q, n)
            heapq.heappush(xq, -n)
        elif c == 'D' and q != []:
            if n == -1:
                while q:
                    v = heapq.heappop(q)
                    if v not in visited:
                        visited.append(v)
                        print(v)
                        break
            else:
                while xq:
                    v = heapq.heappop(xq)
                    if -v not in visited:
                        visited.append(-v)
                        print(-v)
                        break
    max_val = 2**32
    min_val = -2**32
    while q:
        v = heapq.heappop(q)
        if v not in visited:
            min_val = v
            break
    while xq:
        v = heapq.heappop(xq)
        if -v not in visited:
            max_val = -v
            break
    if max_val:
        print('EMPTY')
    else:
        print("{} {}".format(max_val, min_val))