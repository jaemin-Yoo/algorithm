t = int(input())
for idx in range(1, t+1):
    n = int(input())
    graph = []
    for _ in range(n):
        graph.append(list(input()))
    
    result = "NO"
    for i in range(n):
        cnt = 0
        for j in range(n):
            if graph[i][j] == "o":
                cnt += 1
            else:
                cnt = 0
            
            if cnt >= 5:
                break
        
        if cnt >= 5:
            result = "YES"
            break
    
    for j in range(n):
        cnt = 0
        for i in range(n):
            if graph[i][j] == "o":
                cnt += 1
            else:
                cnt = 0
                
            if cnt >= 5:
                break
        
        if cnt >= 5:
            result = "YES"
            break
    
    for i in range(n):
        for j in range(n):
            l_cnt = 0
            r_cnt = 0
            for k in range(5):
                x = i + k
                y = j + k
                if x<n and y<n:
                    if graph[x][y] == "o":
                        l_cnt += 1
                    else:
                        l_cnt = 0
                
                a = i + k
                b = j - k
                if a<n and 0<=b:
                    if graph[a][b] == "o":
                        r_cnt += 1
                    else:
                        r_cnt = 0
    
            if l_cnt >= 5 or r_cnt >= 5:
                break
        if l_cnt >= 5 or r_cnt >= 5:
            result = "YES"
            break
    
    print("#{} {}".format(idx, result))