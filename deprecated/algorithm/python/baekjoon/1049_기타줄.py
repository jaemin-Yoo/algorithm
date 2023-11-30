import sys
input = sys.stdin.readline

n, m = map(int, input().split())
pack = []
inv = []
for _ in range(m):
    p, i = map(int, input().split())
    pack.append(p)
    inv.append(i)

pack.sort()
inv.sort()
result = (n // 6) * pack[0]
a = n % 6

result += min(a * inv[0], pack[0])
print(min(result, n * inv[0]))