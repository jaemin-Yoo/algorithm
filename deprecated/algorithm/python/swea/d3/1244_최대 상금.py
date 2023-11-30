import copy

def solve(arr, start, depth):
    if depth == n:
        v = 0
        for i in range(len(arr)):
            v += arr[i] * (10 ** (len(arr)-i-1))
        
        if v not in result:
            result.append(v)
        return
    
    for i in range(start, len(arr)-1):
        max_val = max(arr[i+1:len(arr)])
        for j in range(i+1, len(arr)):
            if arr[j] == max_val:
                tarr = copy.deepcopy(arr)
                temp = tarr[i]
                tarr[i] = tarr[j]
                tarr[j] = temp
                solve(tarr, i, depth + 1)

t = int(input())
for idx in range(1, t+1):
    num, n = input().split()
    arr = list(map(int, num))
    n = int(n)
    rarr = sorted(arr, reverse=True)
    result = []
    solve(arr, 0, 0)
    print("#{} {}".format(idx, max(result)))