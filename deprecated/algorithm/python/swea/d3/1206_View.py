for idx in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    result = 0
    for i in range(2, n-2):
        l1 = arr[i] - arr[i-1]
        l2 = arr[i] - arr[i-2] 
        r1 = arr[i] - arr[i+1] 
        r2 = arr[i] - arr[i+2]
        if l1 > 0 and l2 > 0 and r1 > 0 and r2 > 0:
            result += min(l1, l2, r1, r2)
    print("#{} {}".format(idx, result))