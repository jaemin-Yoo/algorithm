import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
s = input().strip()

i = 0
cnt = 0
result = 0
while i < m-1:
    if s[i:i+3] == "IOI":
        i += 2
        cnt += 1
        if cnt == n:
            cnt -= 1
            result += 1
    else:
        i += 1
        cnt = 0
print(result)