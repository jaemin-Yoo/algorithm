t = int(input())
for idx in range(1, t+1):
    arr = list(map(int, input().split()))
    arr.remove(max(arr))
    arr.remove(min(arr))
    print("#{} {}".format(idx, round(sum(arr)/len(arr))))