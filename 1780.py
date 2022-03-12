import sys

zero, one, minus = 0, 0, 0
def dnc(x, y , n):
    global zero, one, minus
    check = matrix[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if matrix[i][j] != check:
                check = 9
    
    if check == 9:
        n = n//3
        dnc(x, y, n)
        dnc(x, y+n, n)
        dnc(x, y+2*n, n)
        dnc(x+n, y, n)
        dnc(x+n, y+n, n)
        dnc(x+n, y+2*n, n)
        dnc(x+2*n, y, n)
        dnc(x+2*n, y+n, n)
        dnc(x+2*n, y+2*n, n)
    elif check == 0:
        zero += 1
    elif check == 1:
        one += 1
    else:
        minus += 1
    

input = sys.stdin.readline

n = int(input())
matrix = [list(map(int, input().strip().split())) for _ in range(n)]
dnc(0, 0, n)
print(minus)
print(zero)
print(one)