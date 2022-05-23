def solve(depth, n, m, result):
    if depth == m:
        return result
    
    result *= n
    return solve(depth + 1, n, m, result)

idx = int(input())
n, m = map(int, input().split())
print("#{} {}".format(idx, solve(0, n, m, 1)))