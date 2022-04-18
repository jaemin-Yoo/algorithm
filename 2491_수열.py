import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

upDp = [1 for _ in range(n)]
downDp = [1 for _ in range(n)]
for i in range(1, n):
    if arr[i-1] <= arr[i]:
        upDp[i] = upDp[i-1]+1
    if arr[i-1] >= arr[i]:
        downDp[i] = downDp[i-1]+1
print(max(max(upDp), max(downDp)))