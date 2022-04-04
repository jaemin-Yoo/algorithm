import sys
input = sys.stdin.readline

def dfs(start):
    x, y = start
    if len(arr) == 4:
        s = 0
        for a, b in arr:
            s += graph[a][b]
        result.append(s)
        return
    
    for i in range(4):
        a = x + dx[i]
        b = y + dy[i]
        if 0<=a<n and 0<=b<m and (a, b) not in arr:
            if len(arr) == 2:
                arr.append((a, b))
                dfs(arr[1])
                arr.pop()
            arr.append((a, b))
            dfs((a, b))
            arr.pop()

n, m = map(int, input().split())
graph = []
result = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n):
    graph.append(list(map(int, input().split())))
    
for i in range(n):
    for j in range(m):
        arr = [(i, j)]
        dfs((i, j))
print(max(result))