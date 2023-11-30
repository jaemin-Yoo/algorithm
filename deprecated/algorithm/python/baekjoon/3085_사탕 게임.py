import sys
input = sys.stdin.readline

def solve():
    global result

    for i in range(n):
        a = graph[i][0]
        cnt = 1
        for j in range(1, n):
            if graph[i][j] == a:
                cnt += 1
            else:
                result = max(result, cnt)
                cnt = 1
                a = graph[i][j]
        result = max(result, cnt)

    for j in range(n):
        a = graph[0][j]
        cnt = 1
        for i in range(1, n):
            if graph[i][j] == a:
                cnt += 1
            else:
                result = max(result, cnt)
                cnt = 1
                a = graph[i][j]
        result = max(result, cnt)

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))

result = 1
solve()

for i in range(n):
    for j in range(n):
        if i<n and j+1<n and graph[i][j] != graph[i][j+1]:
            graph[i][j], graph[i][j+1] = graph[i][j+1], graph[i][j]
            solve()
            graph[i][j], graph[i][j+1] = graph[i][j+1], graph[i][j]
        
        if i+1<n and j<n and graph[i][j] != graph[i+1][j]:
            graph[i][j], graph[i+1][j] = graph[i+1][j], graph[i][j]
            solve()
            graph[i][j], graph[i+1][j] = graph[i+1][j], graph[i][j]

print(result)