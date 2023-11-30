import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(input().rstrip()))

l = len(arr[0])
for j in range(l):
    temp = []
    for i in range(n):
        temp.append(arr[i][j])
        
    if len(set(temp)) == 1:
        print(arr[i][j], end="")
    else:
        print("?", end="")