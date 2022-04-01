import sys
import heapq
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    x = int(input())
    if x == 0:
        if not arr:
            print(0)
        else:
            print(heapq.heappop(arr)[1])
            
    else:
        if x < 0:
            heapq.heappush(arr, (-x, x))
        else:
            heapq.heappush(arr, (x, x))