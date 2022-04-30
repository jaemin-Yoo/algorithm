import sys
input = sys.stdin.readline

def dfs():
    if len(temp) == m:
        tmp = ' '.join(map(str, temp))
        if tmp not in result:
            result.append(tmp)
        return
    
    for i in range(n):
        if i not in visited:
            temp.append(arr[i])
            visited.append(i)
            dfs()
            temp.pop()
            visited.pop()
    

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

temp = []
visited = []
result = []
dfs()

for row in result:
    print(row)