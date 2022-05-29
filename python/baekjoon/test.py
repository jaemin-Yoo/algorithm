import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
in_degree = [0] * (n + 1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    in_degree[b] += 1
    graph[a].append(b)

queue = deque()
ans = []

for i in range(1, n+1):
    if in_degree[i] == 0:
        queue.append(i)

while queue:
    current = queue.popleft()
    ans.append(current)

    for x in graph[current]:
        in_degree[x] -= 1

        if in_degree[x] == 0:
            queue.append(x)

print(*ans, end=" ")