import sys
input = sys.stdin.readline

def dfs(weight):
    for i in stack:
        node, wei = graph[i]
        weight += wei
        dfs(node, weight, )
    

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    p, c, w = map(int, input().split())
    graph[p].append((c, w))
stack = [1]
dfs()