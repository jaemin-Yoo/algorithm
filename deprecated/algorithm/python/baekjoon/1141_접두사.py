import sys
input = sys.stdin.readline

graph = []
for _ in range(8):
    graph.append(list(input().rstrip()))

cnt = 0
for i in range(8):
    for j in range(8):
        if (i + j) % 2 == 0 and graph[i][j] == "F":
            cnt += 1
print(cnt)