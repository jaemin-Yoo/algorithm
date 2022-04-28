t = int(input())
for idx in range(1, t+1):
    n = int(input())
    print("#{}".format(idx))
    result = ""
    cnt = 1
    for _ in range(n):
        s, c = input().split()
        for _ in range(int(c)):
            print(s, end="")
            if cnt%10 == 0:
                print()
            cnt += 1
    print()