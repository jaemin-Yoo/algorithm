def solve(start, s):
    global cnt
    
    for i in range(start, n):
        s += arr[i]
        if s > k:
            return
        elif s == k:
            cnt += 1
        else:
            solve(i+1, s)
        s -= arr[i]

t = int(input())
for idx in range(1, t+1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    cnt = 0
    arr.sort()
    solve(0, 0)
    print("#{} {}".format(idx, cnt))