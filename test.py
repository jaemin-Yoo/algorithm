import heapq
arr = []
heapq.heappush(arr, (1, -1))
heapq.heappush(arr, (2, -2))
print(heapq.heappop(arr)[1])