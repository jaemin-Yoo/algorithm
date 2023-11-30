for _ in range(1, 11):
    idx = int(input())
    graph = []
    for _ in range(100):
        graph = list(input())
    
    result = 0
    for i in range(100):
        for j in range(100):
            num = 0
            k = 0
            t = 0
            cnt = 0
            while 100-k-1 != j+t:
                if graph[i][j+t] == graph[i][100-k-1]:
                    cnt += 2
                    k += 1
                    t += 1
                else:
                    cnt = 0
                    num += 1
                    k = num
                    t = 0
            result = max(result, cnt+1)
    print("#{} {}".format(idx, result))