t = int(input())
for i in range(1, t+1):
    n = int(input())
    print("#{}".format(i))
    
    arr = [0, 1, 0]
    for _ in range(n):
        for v in arr:
            if v != 0:
                print(v, end=" ")
        print()
        
        temp = []
        for j in range(1, len(arr)):
            temp.append(arr[j-1] + arr[j])
        temp.insert(0, 0)
        temp.append(0)
        arr = temp