t = int(input())
for idx in range(1, t+1):
    n = int(input())
    score = list(map(int, input().split()))
    
    arr = [0 for _ in range(101)]
    for i in score:
        arr[i] += 1
    
    mode = max(arr)
    for i in range(100, -1, -1):
        if arr[i] == mode:
            result = i
            break
    
    print("#{} {}".format(idx, result))