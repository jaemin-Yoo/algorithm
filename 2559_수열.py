import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))

dp = [-1e9 for _ in range(n)]
dp[0] = arr[0]
for i in range(1, k):
    dp[i] = arr[i] + dp[i-1]

for i in range(k, n):
    dp[i] = arr[i] + dp[i-1] - arr[i-k]

print(max(dp[k-1:]))