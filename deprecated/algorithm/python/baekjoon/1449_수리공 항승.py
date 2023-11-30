import sys
input = sys.stdin.readline

n, l = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

cnt = 0
pos = 0
for i in range(n):
    if arr[i] > pos:
        pos = arr[i] + l - 1
        cnt += 1
    
    if arr[-1] <= pos:
        break
print(cnt)