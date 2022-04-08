import sys
input = sys.stdin.readline

graph = [[0 for _ in range(100)] for _ in range(100)]
for _ in range(4):
    bx, by, tx, ty = map(int, input().split())
    for i in range(bx, tx):
        for j in range(by, ty):
            graph[i][j] = 1
result = 0
for row in graph:
    result += sum(row)
print(result)