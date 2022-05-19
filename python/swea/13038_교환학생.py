t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    
    min_days = 10^9
    print(min_days)
    for days in range(7):
        cnt = 0
        while True:
            cnt += arr[days%7]
            days += 1
            if cnt == n:
                print(min_days, days)
                min_days = min(min_days, days)
                break
            
    print("#{} {}".format(idx, min_days))