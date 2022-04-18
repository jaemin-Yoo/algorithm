import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

cnt = 1
upCnt = 1
for i in range(1, n):
    if arr[i-1] <= arr[i]:
        cnt += 1
    else:
        upCnt = max(cnt, upCnt)
        cnt = 1
upCnt = max(cnt, upCnt)

cnt = 1
downCnt = 1
for i in range(1, n):
    if arr[i-1] >= arr[i]:
        cnt += 1
    else:
        downCnt = max(cnt, downCnt)
        cnt = 1
downCnt = max(cnt, downCnt)

print(max(upCnt, downCnt))