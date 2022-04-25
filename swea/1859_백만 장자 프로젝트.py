t = int(input())
for idx in range(1, t+1):
    n = int(input())
    days = list(map(int, input().split()))
    
    max_val = 0
    temp = [0 for _ in range(n)]
    for i in range(n-1, -1, -1):
        max_val = max(max_val, days[i])
        temp[i] = max_val
        
    result = 0
    for i in range(n):
        result += temp[i] - days[i]
    
    print("#{} {}".format(idx, result))