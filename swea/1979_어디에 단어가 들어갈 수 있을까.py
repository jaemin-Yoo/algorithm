t = int(input())
for idx in range(1, t+1):
    n, k = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
    
    result = 0
    for i in range(n):
        cnt = 0
        for j in range(n):
            if cnt == k and graph[i][j] == 0:
                cnt = 0
                result += 1
            
            if graph[i][j] == 1:
                cnt += 1
            else:
                cnt = 0
        if cnt == k:
            result += 1
            
    
    for j in range(n):
        cnt = 0
        for i in range(n):
            if cnt == k and graph[i][j] == 0:
                cnt = 0
                result += 1
                
            if graph[i][j] == 1:
                cnt += 1
            else:
                cnt = 0
        if cnt == k:
            result += 1
     
    print("#{} {}".format(idx, result))