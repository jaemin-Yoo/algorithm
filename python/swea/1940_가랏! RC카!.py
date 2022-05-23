t = int(input())
for idx in range(1, t+1):
    n = int(input())
    
    m = 0
    currentMs = 0
    for _ in range(n):
        s = input()
        if s == "0":
            c = int(s)
        else:
            c, ms = map(int, s.split())
        
        if c == 1:
            currentMs += ms
            m += currentMs
        elif c == 2:
            currentMs -= ms
            if currentMs < 0:
                currentMs = 0
            m += currentMs
        else:
            m += currentMs
    print("#{} {}".format(idx, m))