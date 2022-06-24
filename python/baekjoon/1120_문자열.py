import sys
input = sys.stdin.readline

a, b = input().rstrip().split()
result = len(a)
for i in range(len(b) - len(a)+1):
    cnt = 0
    for j in range(len(a)):
        if a[j] != b[i+j]:
            cnt += 1
    result = min(cnt, result)
print(result)