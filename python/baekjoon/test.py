# 11051

n, k = map(int, input().split())
if n-k < k:
    k = n-k

t = 1
b = 1
for i in range(1, k+1):
    t *= n - i + 1
    b *= i
print((t//b)%10007)