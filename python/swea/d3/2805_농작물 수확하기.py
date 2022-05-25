t = int(input())
for idx in range(1, t+1):
    n = int(input())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input())))
    
    result = 0
    for i in range(n):
        if i < n//2:
            print(sum(graph[i][n//2-i:n//2+i+1]))
            result += sum(graph[i][n//2-i:n//2+i+1])
        else:
            print(sum(graph[i][n//2-(n-i-1):n//2+(n-i)]))
            result += sum(graph[i][n//2-(n-i-1):n//2+(n-i)])