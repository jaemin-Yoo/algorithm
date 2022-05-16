import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def solve():
    if len(arr) == n:
        cnt = 0
        temp = 0
        for i in range(n):
            if arr[i] == "C":
                cnt += 1
            else:
                temp = max(temp, cnt)
                cnt = 0
        temp = max(temp, cnt)
        result.append(temp)
        return
    
    for i in range(n):
        if i not in visited:
            arr.append(s[i])
            visited.add(i)
            solve()
            arr.pop()
            visited.remove(i)

n = int(input())
s = input().rstrip()
arr = []
visited = set()
result = []
solve()
print(min(result))