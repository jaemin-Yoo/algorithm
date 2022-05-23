t = int(input())
for i in range(1, t+1):
    arr = list(map(int, input().split()))
    
    result = 0
    for v in arr:
        if v % 2 == 1:
            result += v
    print("#{} {}".format(i, result))