import math

t = int(input())
for idx in range(1, t+1):
    n = int(input())
    result = 0
    for _ in range(n):
        x, y = map(int, input().split())
        result += int(-math.sqrt(x*x + y*y)/20 + 11)
    print("#{} {}".format(idx, result))