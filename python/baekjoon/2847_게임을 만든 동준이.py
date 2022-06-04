import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

start = arr[-1]
cnt = 0
for i in range(n-2, -1, -1):
    if arr[i] >= start:
        cnt += arr[i] - start + 1
        start = start - 1
    else:
        start = arr[i]

print(cnt)