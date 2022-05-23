t = int(input())
for idx in range(1, t+1):
    s = input()
    v = "0"
    cnt = 0
    for i in s:
        if i != v:
            cnt += 1
            v = i
    print("#{} {}".format(idx, cnt))