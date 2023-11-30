import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort(reverse=True)
result = arr[0]
for i in range(1, n):
    result = max(result, arr[i] * (i+1))
print(result)