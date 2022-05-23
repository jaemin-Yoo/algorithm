week = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]

t = int(input())
for idx in range(1, t+1):
    s = input()
    n = week.index(s)
    
    cnt = 0
    while True:
        n += 1
        cnt += 1
        if week[n%7] == "SUN":
            break
    
    print("#{} {}".format(idx, cnt))