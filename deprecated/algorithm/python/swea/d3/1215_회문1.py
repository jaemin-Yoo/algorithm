for idx in range(1, 11):
    n = int(input())
    graph = []
    for _ in range(8):
        graph.append(list(input()))
    
    result = 0
    for i in range(8):
        for j in range(8):
            state = True
            for k in range(n//2):
                if j+k < 8 and j+n-k-1 < 8 and graph[i][j+k] != graph[i][j+n-k-1]:
                    state = False
            if state and 8-j >= n:
                result += 1
            
            state = True
            for k in range(n//2):
                if i+k < 8 and i+n-k-1 < 8 and graph[i+k][j] != graph[i+n-k-1][j]:
                    state = False
            if state and 8-i >= n:
                result += 1
    
    print("#{} {}".format(idx, result))