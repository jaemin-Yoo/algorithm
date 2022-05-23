t = int(input())

money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for idx in range(1, t+1):
    n = int(input())
    
    arr = [0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(8):
        q = n // money[i]
        if q > 0:
            arr[i] = q
            n -= money[i] * q
    print("#{}".format(idx))
    print(*arr)