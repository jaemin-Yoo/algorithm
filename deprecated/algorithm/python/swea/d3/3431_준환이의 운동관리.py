t = int(input())
for idx in range(1, t+1):
    l, u, x = map(int, input().split())
    result = 0
    if x<l:
        result = l-x
    elif x>u:
        result = -1
    
    print("#{} {}".format(idx, result))