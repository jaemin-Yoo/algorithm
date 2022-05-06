import sys
import heapq
input = sys.stdin.readline

def dijkstra(start):
    dp[start] = 0
    heapq.heappush(heap, [0, start])
    while heap:
        w, n = heapq.heappop(heap)
        for wei, n_n in graph[n]:
            n_w = wei + w
            if n_w < dp[n_n]:
                dp[n_n] = n_w
                heapq.heappush(heap, [n_w, n_n])

V, E = map(int, input().split())
K = int(input())

INF = sys.maxsize
graph = [[] for _ in range(V+1)]
dp = [INF] * (V+1)
heap = []
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append([w, v])

dijkstra(K)
for i in dp[1:]:
    print(i if i != INF else "INF")