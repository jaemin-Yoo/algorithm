t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    
    min_days = 1000000000
    for start in range(7):
        cnt = 0
        days = 0
        while True:
            cnt += arr[(start+days)%7]
            days += 1
            if cnt == n:
                min_days = min(min_days, days)
                break
            
    print("#{} {}".format(idx, min_days))