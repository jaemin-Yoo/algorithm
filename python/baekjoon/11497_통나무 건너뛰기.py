import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    arr = list(map(int, input().split()))

    arr = sorted(arr, reverse=True)
    left = arr[0] - arr[1]
    right = arr[0] - arr[2]
    ans = [left, right]

    for i in range(1, n-2):
        if i % 2 == 1:
            ans.append(arr[i] - arr[i+2])
        else:
            ans.append(arr[i] - arr[i+2])
    
    print(max(ans))