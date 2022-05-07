t = int(input())
for idx in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    print("#{} ".format(idx), end="")
    print(*arr)