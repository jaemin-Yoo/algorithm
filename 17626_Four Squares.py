import sys
input = sys.stdin.readline
n = int(input())

i = 1
cnt = 0
while n > 0:
    if n < i ** 2:
        n = n - (i-1) ** 2
        print(i-1)
        cnt += 1
        i = 0
    i += 1
print(cnt)