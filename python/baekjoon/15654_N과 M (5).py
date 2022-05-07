import sys
input = sys.stdin.readline

def combine():
    for i in range(n):
        if len(temp) == m:
            print(*temp)
            return
        
        if arr[i] not in temp:
            temp.append(arr[i])
            combine()
            temp.pop()

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

temp = []
combine()