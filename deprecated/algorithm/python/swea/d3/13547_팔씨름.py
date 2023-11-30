t = int(input())
for idx in range(1, t+1):
    s = input()
    x_cnt = 0
    for i in s:
        if i == "x":
            x_cnt += 1
    
    result = ""
    if x_cnt < 8:
        result = "YES"
    else:
        result = "NO"
    
    print("#{} {}".format(idx, result))