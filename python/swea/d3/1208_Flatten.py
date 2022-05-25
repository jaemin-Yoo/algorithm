for idx in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    
    for _ in range(n):
        arr[arr.index(max(arr))] -= 1
        arr[arr.index(min(arr))] += 1
    
    print("#{} {}".format(idx, max(arr) - min(arr)))