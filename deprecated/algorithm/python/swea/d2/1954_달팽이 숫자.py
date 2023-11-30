t = int(input())
for idx in range(1, t+1):
    n = int(input())
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    graph = [[0 for _ in range(n)] for _ in range(n)]
    x = 0
    y = 0
    d = 0
    graph[x][y] = 1
    for i in range(2, n*n+1):
        a = x+dx[d%4]
        b = y+dy[d%4]
        
        if 0>a or a>=n or 0>b or b>=n or graph[a][b] != 0:
            d += 1
            a = x+dx[d%4]
            b = y+dy[d%4]
        
        if 0<=a<n and 0<=b<n and graph[a][b] == 0:
            graph[a][b] = i
        
        x = a
        y = b
    print("#{}".format(idx))
    for row in graph:
        print(*row)