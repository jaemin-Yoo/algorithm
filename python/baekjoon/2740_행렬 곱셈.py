import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))

m, k = map(int, input().split())
b = []
for _ in range(m):
    b.append(list(map(int, input().split())))

for i in range(n):
    for j in range(k):
        v = 0
        for t in range(m):
            v += a[i][t] * b[t][j]
        print(v, end=" ")
    print()