import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    graph = []
    graph.append(list(map(int, input().split())))
    graph.append(list(map(int, input().split())))
    
    graph[0][1] += graph[1][0]
    graph[1][1] += graph[0][0]
    for j in range(2, n):
        for i in range(2):
            if i == 0:
                graph[i][j] += max(graph[i+1][j-1], graph[i+1][j-2])
            else:
                graph[i][j] += max(graph[i-1][j-1], graph[i-1][j-2])
    
    print(max(graph[0][n-1], graph[1][n-1]))