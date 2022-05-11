import sys
input = sys.stdin.readline

n = int(input())
arr = []
dp = [0 for i in range(n+1)]
for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(n-1, -1, -1):
    if arr[i][0] + i > n:
        dp[i] = 0
    else:
        dp[i] = max(arr[i][1] + dp[i+arr[i][0]], dp[i+1])
print(dp[0])