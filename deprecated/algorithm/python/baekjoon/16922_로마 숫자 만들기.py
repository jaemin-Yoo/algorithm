import sys
input = sys.stdin.readline

rome = [1, 5, 10, 50]

def solve(start):
    global cnt
    
    if len(arr) == n:
        if sum(arr) not in result:
            result.append(sum(arr))
            cnt += 1
        return
    
    for i in range(start, 4):
        arr.append(rome[i])
        solve(i)
        arr.pop()

n = int(input())
arr = []
result = []
cnt = 0
solve(0)
print(cnt)