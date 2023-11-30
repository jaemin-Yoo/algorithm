def check(n):
    c = 0
    for i in str(n):
        if arr[int(i)] == 0:
            arr[int(i)] = 1
            c += 1
    return c

t = int(input())
for idx in range(1, t+1):
    n = int(input())
    
    cnt = 0
    result = 1
    arr = [0 for _ in range(10)]
    while True:
        if cnt == 10:
            break
        
        cnt += check(n * result)
        result += 1
    
    print("#{} {}".format(idx, n * (result-1)))