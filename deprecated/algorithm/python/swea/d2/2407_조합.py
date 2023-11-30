import sys
input = sys.stdin.readline

n, m = map(int, input().split())
if n - m < m:
    m = n - m

c, p = 1, 1
for _ in range(m):
    c *= n
    p *= m
    n -= 1
    m -= 1
print(c//p)