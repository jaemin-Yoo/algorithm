dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = [[0 for _ in range(n)] for _ in range(n)]
    i, j = 0, 0
    v = 1
    arr[i][j] = 1
    k = 0
    while n**2 > v:
        if 0<=i+dx[k]<n and 0<=j+dy[k]<n and arr[i+dx[k]][j+dy[k]] == 0:
            i += dx[k]
            j += dy[k]
            v += 1
            arr[i][j] = v
        else:
            k = (k+1)%4
            
    print("#{}".format(idx))
    for row in arr:
        print(*row)