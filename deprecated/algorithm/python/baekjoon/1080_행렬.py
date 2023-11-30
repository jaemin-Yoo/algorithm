import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().rstrip())))

b = []
for _ in range(n):
    b.append(list(map(int, input().rstrip())))

result = 0
for i in range(n):
    for j in range(m):
        if a[i][j] != b[i][j]:
            if 0<=i+2<n and 0<=j+2<m:
                for p in range(3):
                    for q in range(3):
                        a[i+p][j+q] = (a[i+p][j+q]+1)%2
                result += 1
            else:
                result = -1
                break
    if result == -1:
        break

print(result)