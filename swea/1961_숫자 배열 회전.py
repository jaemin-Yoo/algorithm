def rotate(n, graph):
    result = []
    for j in range(n):
        row = []
        for i in range(n-1, -1, -1):
            row.append(str(graph[i][j]))
        result.append(row)
    
    return result

t = int(input())
for idx in range(1, t+1):
    n = int(input())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
    
    graph_90 = rotate(n, graph)
    graph_180 = rotate(n, graph_90)
    graph_270 = rotate(n, graph_180)
    
    print("#{}".format(idx))
    for i in range(n):
        print("".join(graph_90[i]), end=" ")
        print("".join(graph_180[i]), end=" ")
        print("".join(graph_270[i]))
            
    