arr = list(map(int, input().split()))
result = []
for i in set(arr):
    v = arr.count(i)
    if v > 1:
        result.append(v)
if result:
    print(result)
else:
    print([-1])