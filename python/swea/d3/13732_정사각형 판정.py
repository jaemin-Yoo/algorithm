import math

t = int(input())
for idx in range(1, t+1):
    n = int(input())
    graph = []
    for _ in range(n):
        row = list(input())
        graph.append(row)
    
    cnt = 0
    sharp = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == "#":
                sharp.append((i,j))
                cnt += 1
    
    if len(sharp) != 0:
        a, b = sharp[0]
        result = "yes"
    else:
        result = "no"
    
    row_cnt = 1
    col_cnt = 1
    for i in range(1, len(sharp)):
        x, y = sharp[i]
        if x == a and y == b + 1:
            a = x
            b = y
            row_cnt += 1
        elif x == a + 1 and y == sharp[0][1] and row_cnt > col_cnt:
            a = x
            b = y
            row_cnt = 1
            col_cnt += 1
        else:
            result = "no"
            break
        
    if row_cnt != col_cnt:
        result = "no"
    
    print("#{} {}".format(idx, result))