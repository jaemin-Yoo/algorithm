import sys
input = sys.stdin.readline

def combine(s):
    if len(temp) == m:
        print(*temp)
        return
    
    for i in range(s, n):
        temp.append(arr[i])
        combine(i)
        temp.pop()
    
n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
temp = []
combine(0)