import sys
input = sys.stdin.readline

n = int(input())
arr = [0 for _ in range(n+1)]
dp = [0 for _ in range(n+1)]
for i in range(1, n+1):
    t, p = map(int, input().split())
    arr[i] = (i+t, p)

for i in range(1, n+1):
    if arr[i][0] <= n+1:
        for j in range(1, i):
            if arr[j][0] <= i:
                dp[i] = max(dp[i], arr[i][1] + dp[j])
        
        if dp[i] == 0:
            dp[i] = arr[i][1]
print(max(dp))