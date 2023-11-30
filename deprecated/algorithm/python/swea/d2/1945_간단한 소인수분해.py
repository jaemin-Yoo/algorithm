t = int(input())
arr = [2, 3, 5, 7, 11]
for idx in range(1, t+1):
    n = int(input())
    
    temp = [0, 0, 0, 0, 0]
    for i, v in enumerate(arr):
        while n % v == 0:
            temp[i] += 1
            n = n // v
            
    print("#{} {} {} {} {} {}".format(idx, *temp))