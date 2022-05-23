max_a = int((10**7)**0.5)
arr = [True, True] + [False for _ in range(2, max_a+1)]
for i in range(2, int(max_a**0.5)+1):
    if arr[i] == False:
        for j in range(i*2, max_a+1, i):
            arr[j] = True

dec = []
for i in range(2, len(arr)):        
    if arr[i] == False:
        dec.append(i)

t = int(input())
res = []
for idx in range(1, t+1):
    a = int(input())
    result = 1

    for v in dec:
        cnt = 0
        while a % v == 0:
            a //= v
            cnt += 1
        if cnt % 2 != 0:
            result *= v
        if a == 1:
            break
    if a > 1:
        result *= a
            
    res.append(result)

for idx in range(1, t+1):
    print("#{} {}".format(idx, res[idx-1]))