import sys
input = sys.stdin.readline

def dfs(start):
    if len(temp) == m:
        tmp = " ".join(map(str, temp))
        if tmp not in result:
            result.append(tmp)
        return
    
    for i in range(start, n):
        temp.append(arr[i])
        dfs(i)
        temp.pop()

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
temp = []
result = []
dfs(0)
for row in result:
    print(row)