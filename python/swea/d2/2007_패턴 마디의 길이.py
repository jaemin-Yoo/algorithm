t = int(input())
for idx in range(1, t+1):
    s = input()
    
    for i in range(1, 11):
        if s[:i] == s[i:i*2]:
            print("#{} {}".format(idx, i))
            break