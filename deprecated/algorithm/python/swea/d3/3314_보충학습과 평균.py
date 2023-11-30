t = int(input())
for idx in range(1, t+1):
    arr = list(map(int, input().split()))
    
    s = 0
    for i in arr:
        if i < 40:
            s += 40
        else:
            s += i
    print("#{} {}".format(idx, int(s/5)))