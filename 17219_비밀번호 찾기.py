import sys
input = sys.stdin.readline
n, m = map(int, input().strip().split())

d = {}
for _ in range(n):
    email, pw = input().strip().split()
    d[email] = pw

for _ in range(m):
    email = input().strip()
    print(d[email])