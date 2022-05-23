t = int(input())
for idx in range(1, t+1):
    s = input()
    state = 1
    for i in range(len(s)//2):
        if s[i] != s[len(s)-i-1]:
            state = 0
            break
    
    print("#{} {}".format(idx, state))