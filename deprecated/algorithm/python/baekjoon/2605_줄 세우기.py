import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
result = []
for i, v in enumerate(arr):
    result.insert(len(result) - v, i+1)
print(*result)