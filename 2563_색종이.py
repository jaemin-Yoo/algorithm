import sys
input = sys.stdin.readline

n = int(input())
graph = [[0 for _ in range(100)] for _ in range(100)]
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            graph[i][j] = 1
result = 0
for row in graph:
    result += sum(row)
print(result)