def check(n):
    s = str(n)
    l = len(s)
    for i in range(l//2):
        if s[i] != s[l-i-1]:
            return False
    return True

t = int(input())
for idx in range(1, t+1):
    a, b = map(int, input().split())
    cnt = 0
    for i in range(a, b+1):
        if i**0.5 == int(i**0.5) and check(int(i**0.5)) and check(i):
            cnt += 1
    print("#{} {}".format(idx, cnt))