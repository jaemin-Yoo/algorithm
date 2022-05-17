import math
t = int(input())
for idx in range(1, t+1):
    n, d = map(int, input().split())
    print("#{} {}".format(idx, math.ceil(n / (d * 2 + 1))))