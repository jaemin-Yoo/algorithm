for _ in range(1, 11):
    idx = int(input())
    graph = []
    for _ in range(100):
        graph = list(input())
    
    result = 0
    for n in range(100, -1, -1):
        for i in range(100):
            for j in range(100):
                state = True
                for k in range(n//2):
                    if 0<=j+k<100 and 0<=j+n-k-1<100 and graph[i][j+k] != graph[i][j+n-k-1]:
                        state = False
                if state:
                    break
            if state:
                break
        if state:
            break
    
    print("#{} {}".format(idx, n))