import sys

def dnc(x, y, n):
    check = graph[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if graph[i][j] != check:
                check = -1
                break
    
    if check == -1:
        print("(", end="")
        n = n // 2
        dnc(x, y, n)
        dnc(x, y+n, n)
        dnc(x+n, y, n)
        dnc(x+n, y+n, n)
        print(")", end="")
        
    elif check == 1:
        print("1", end="")
    else:
        print("0", end="")
    
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().strip())) for _ in range(n)]
dnc(0, 0, n)