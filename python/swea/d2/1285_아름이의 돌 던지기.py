t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    
    min_dst = 100000
    cnt = 0
    for i in arr:
        if min_dst > abs(i):
            min_dst = abs(i)
            cnt = 1
        elif min_dst == abs(i):
            cnt += 1
    
    print("#{} {} {}".format(idx, min_dst, cnt))