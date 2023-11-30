import sys
import heapq
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    heapq.heappush(arr, int(input()))
    
result = 0
for i in range(n-1):
    v = heapq.heappop(arr) + heapq.heappop(arr)
    heapq.heappush(arr, v)
    result += v

print(result)