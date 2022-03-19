import sys
input = sys.stdin.readline
n, m = map(int, input().strip().split())

a = set()
for _ in range(n):
    a.add(input().strip())

b = set()
for _ in range(m):
    b.add(input().strip())

result = sorted(list(a&b))
print(len(result))
for s in result:
    print(s)