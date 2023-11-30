import sys
input = sys.stdin.readline
n, m = map(int, input().split())
d = {}
for i in range(1, n+1):
    v = input().strip()
    d[v] = i
    d[str(i)] = v
for _ in range(m):
    v = input().strip()
    print(d[v])