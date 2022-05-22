arr = [True, True] + [False for _ in range(2, 10^7+1)]
dec = []
for i in range(2, a+1):
    if i*i > a:
        break
    
    if arr[i] == False:
        dec.append(i)
        for j in range(i, a+1, i):
            arr[j] = True

for i in range(2, a+1):
    if arr[i] == False:
        dec.append(i)
    

t = int(input())
for idx in range(1, t+1):
    a = int(input())

    result = 1
    for v in dec:
        cnt = 0
        while a % v == 0:
            a /= v
            cnt += 1
        if cnt % 2 != 0:
            result *= v
            
    print("#{} {}".format(idx, result))