# from queue import PriorityQueue

# q = PriorityQueue()
# q.put((1, 31))
# q.put((2, 30))
# print(q.get())


# xq = PriorityQueue()
# xq.put((31, 1))
# xq.put((30, 2))
# print(xq.get(-1)[1])

import heapq

test = []
heapq.heappush(test, 2)
heapq.heappush(test, 1)
heapq.heappush(test, 3)
test.remove(1)
print(heapq.heappop(test))