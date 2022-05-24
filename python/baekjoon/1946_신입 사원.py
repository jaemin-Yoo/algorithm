import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    arr = []
    for _ in range(n):
        a, b = map(int, input().split())
        arr.append((a, b))

    arr = sorted(arr, key=lambda x:x[0])
    rank = arr[0][1]
    cnt = n
    for i in range(1, n):
        if arr[i][1] > rank:
            cnt -= 1
        else:
            rank = arr[i][1]

    print(cnt)