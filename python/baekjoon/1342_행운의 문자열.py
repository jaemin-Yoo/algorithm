import sys
input = sys.stdin.readline

def dfs(prev):
    global result, cnt
    
    if len(result) == len(arr):
        cnt += 1
        return
    
    for k, v in d.items():
        if prev != k and v > 0:
            result.append(k)
            d[k] -= 1
            dfs(k)
            d[k] += 1
            result.pop()

arr = list(input().rstrip())
d = {}
result = []
cnt = 0
for a in set(arr):
    d[a] = arr.count(a)
dfs("")
print(cnt)