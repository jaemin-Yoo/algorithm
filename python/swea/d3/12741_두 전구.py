t = int(input())
result = []
for idx in range(1, t+1):
    a, b, c, d = map(int, input().split())
    time = min(b, d) - max(a, c)
    if time < 0:
        result.append(0)
    else:
        result.append(time)

for idx in range(t):
    print("#{} {}".format(idx+1, result[idx]))