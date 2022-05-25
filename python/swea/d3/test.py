for _ in range(1, 11):
    idx = int(input())
    graph = []
    for _ in range(100):
        graph.append(list(input()))
    
    result = 0
    for n in range(100, -1, -1):
        for i in range(100):
            for j in range(100):
                state = True
                for k in range(n//2):
                    if 0<=j+k<100 and 0<=j+n-k-1<100:
                        if graph[i][j+k] != graph[i][j+n-k-1]:
                            state = False
                    else:
                        state = False
                        
                if state:
                    result = n
                    break
                
                state = True
                for k in range(n//2):
                    if 0<=i+k<100 and 0<=i+n-k-1<100:
                        if graph[i+k][j] != graph[i+n-k-1][j]:
                            state = False
                    else:
                        state = False
                        
                if state:
                    result = n
                    break
            if state:
                break
        if state:
            break
    
    print("#{} {}".format(idx, result))