def check():
    for i in range(1, n+1):
        x = (pd * i) / 100
        y = (pd * i) // 100
        if x == y:
            return "Possible"
    return "Broken"
    
t = int(input())
for idx in range(1, t+1):
    n, pd, pg = map(int, input().split())
    
    result = "Possible"
    if pg == 100 and pd != 100:
        result = "Broken"
    elif pg == 0 and pd != 0:
        result = "Broken"
    else:
        result = check()
        
    print("#{} {}".format(idx, result))