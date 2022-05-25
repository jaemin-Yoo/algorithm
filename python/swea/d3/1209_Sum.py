for _ in range(10):
    idx = int(input())
    graph = []
    for _ in range(100):
        graph.append(list(map(int, input().split())))
    
    result = 0
    for i in range(100):
        result = max(result, sum(graph[i]))
    
    for i in range(100):
        result = max(result, sum([graph[j][i] for j in range(100)]))
    
    s = 0
    for i in range(100):
        s += graph[i][i]
    result = max(result, s)
    
    s = 0
    for i in range(100):
        s += graph[i][100-i-1]
    result = max(result, s)
    
    print("#{} {}".format(idx, result))