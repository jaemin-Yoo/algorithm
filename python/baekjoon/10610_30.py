import sys
input = sys.stdin.readline

arr = list(map(int, input().rstrip()))
arr.sort(reverse=True)
if arr[-1] == 0 and sum(arr) % 3 == 0:
    for i in arr:
        print(i, end="")
else:
    print(-1)