t = int(input())
for idx in range(1, t+1):
    r1, r2 = map(int, input().split())
    s1, s2 = 1, 0
    t1, t2 = 0, 1
    while r2 > 0:
        q = r1 // r2
        r = r1 - q * r2
        r1, r2 = r2, r

        s = s1 - q * s2
        s1, s2 = s2, s

        t = t1 - q * t2
        t1, t2 = t2, t

    if r1 == 1:
        print("#{} {} {}".format(idx, s1, t1))
    else:
        print("#{} -1".format(idx))