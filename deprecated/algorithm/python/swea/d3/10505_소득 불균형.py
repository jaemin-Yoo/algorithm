t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    avg = sum(arr)/len(arr)
    cnt = 0
    for i in arr:
        if i <= avg:
            cnt += 1
    print("#{} {}".format(idx, cnt))