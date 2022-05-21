t = int(input())
for idx in range(1, t+1):
    a, b, c, d = map(int, input().split())
    result = min(b, d) - max(a, c)
    if result < 0:
        result = 0
    print("#{} {}".format(idx, result))