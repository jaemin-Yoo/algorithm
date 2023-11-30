for idx in range(1, 11):
    n = int(input())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
    
    cnt = 0
    for j in range(n):
        state = 0
        for i in range(n):
            if graph[i][j] == 1:
                state = 1
            elif graph[i][j] == 2 and state == 1:
                cnt += 1
                state = 2
    
    print("#{} {}".format(idx, cnt))