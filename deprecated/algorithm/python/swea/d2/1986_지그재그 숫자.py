t = int(input())
for idx in range(1, t+1):
    n = int(input())
    result = 0
    for i in range(1, n+1):
        if i % 2 == 0:
            result -= i
        else:
            result += i
    print("#{} {}".format(idx, result))