import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
graph.append([0] * (n+1))
for _ in range(n):
    graph.append([0] + list(map(int, input().split())))
    
for i in range(1, n+1):
    for j in range(1, n+1):
        graph[i][j] += graph[i][j-1]

temp = []
for _ in range(m):
    temp.append(list(map(int, input().split())))
    
for x1, y1, x2, y2 in temp:
    result = 0
    for i in range(x1, x2+1):
        result += graph[i][y2] - graph[i][y1-1]
    print(result)