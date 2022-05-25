import sys
input = sys.stdin.readline

a, b = map(int, input().split())
cnt = 0
while True:
    if b == a:
        print(cnt+1)
        break
    elif b < a:
        print(-1)
        break

    if b % 2 == 0:
        b //= 2
        cnt += 1
    elif str(b)[-1] == "1":
        b = (b-1)//10
        cnt += 1
    else:
        print(-1)
        break