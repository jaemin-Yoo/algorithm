t = int(input())
for idx in range(1, t+1):
    n, m = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
        
    result = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            s = 0
            for row in graph[i:i+m]:
                s += sum(row[j:j+m])
            result = max(result, s)

    print("#{} {}".format(idx, result))