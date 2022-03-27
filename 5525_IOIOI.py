import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
s = input().strip()

cnt = 0
result = 0
prev = s[0]
state = False
for i in range(1, m):
    if prev == "I" and s[i] == "O":
        state = True
    elif prev == "I" and s[i] == "I":
        tmp = cnt - n + 1
        if tmp > 0:
            result += cnt - n + 1
        cnt = 0
        state = False
    elif prev == "O" and s[i] == "O":
        tmp = cnt - n + 1
        if tmp > 0:
            result += cnt - n + 1
        cnt = 0
        state = False
    elif prev == "O" and s[i] == "I" and state:
        cnt += 1
        state = False
        
    prev = s[i]

tmp = cnt - n + 1
if tmp > 0:
    result += cnt - n + 1
print(result)