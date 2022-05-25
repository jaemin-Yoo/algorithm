for idx in range(1, 11):
    n = int(input())
    graph = []
    for _ in range(8):
        graph.append(list(input()))
    
    cnt = 0
    for i in range(8):
        for j in range(8):
            state = True
            for k in range(n//2):
                if j+k < 8 and j+n-1-k < 8 and graph[i][j+k] != graph[i][j+n-1-k]:
                    state = False
                    break
            if state and j+n <= 8:
                cnt += 1
                
            state = True
            for k in range(n//2):
                if i+k < 8 and i+n-1-k < 8 and graph[i+k][j] != graph[i+n-1-k][j]:
                    state = False
                    break
            if state and i+n <= 8:
                cnt += 1
                
    print("#{} {}".format(idx, cnt))