import sys
input = sys.stdin.readline

cnt = -1
def dnc(x, y, n):
    global cnt
    
    if n == 2:
        for i in range(x, x+2):
            for j in range(y, y+2):
                cnt += 1
                if i == r and j == c:
                    print(cnt)
                    exit()
        return
    
    n = n//2
    if x <= r < x+n and y <= c < y+n:
        dnc(x, y, n)
    else:
        cnt += n * n
        
    if x <= r < x+n and y+n <= c < y+n*2:
        dnc(x, y+n, n)
    else:
        cnt += n * n
        
    if x+n <= r < x+n*2 and y <= c < y+n:
        dnc(x+n, y, n)
    else:
        cnt += n * n
        
    if x+n <= r < x+n*2 and y+n <= c < y+n*2:
        dnc(x+n, y+n, n)

N, r, c = map(int, input().split())
dnc(0, 0, 2**N)