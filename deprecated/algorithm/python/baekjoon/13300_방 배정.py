import sys
import math
input = sys.stdin.readline

n, k = map(int, input().split())
std = [[] for _ in range(7)]
for _ in range(n):
    s, y = map(int, input().split())
    std[y].append(s)

result = 0
for i in range(1, 7):
    result += math.ceil(std[i].count(0)/k)
    result += math.ceil(std[i].count(1)/k)
print(result)