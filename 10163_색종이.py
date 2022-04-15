import sys
input = sys.stdin.readline

n = int(input())
result = [0 for _ in range(n+1)]
graph = [[0 for _ in range(1001)] for _ in range(1001)]
for k in range(1, n+1):
    a, b, w, h = map(int, input().split())
    for i in range(a, a+w):
        for j in range(b, b+h):
            graph[i][j] = k

for i in range(1001):
    for j in range(1001):
        result[graph[i][j]] += 1

for i in range(1, n+1):
    print(result[i])