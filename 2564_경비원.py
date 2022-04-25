import sys
input = sys.stdin.readline

w, h = map(int, input().split())
n = int(input())

direction = [1, 3, 2, 4]
arr = [[], [], [], [], []]
for _ in range(n):
    d, dst = map(int, input().split())
    arr[d].append(dst)
x, y = map(int, input().split())

result = 0
if x == 2:
    for i in arr[2]:
        result += abs(i - y)
    for i in arr[3]:
        result += (h-i) + y
    for i in arr[4]:
        result += (h-i) + (w-y)
    for i in arr[1]:
        if i >= w-y:
            result += (w-y) + h + (w-i)
        else:
            result += y + h + i
elif x == 3:
    for i in arr[3]:
        result += abs(i - y)
    for i in arr[1]:
        result += i + y
    for i in arr[2]:
        result += (h-y) + i
    for i in arr[4]:
        if i >= h-y:
            result += (h-y) + w + (h-i)
        else:
            result += y + w + i
elif x == 1:
    for i in arr[1]:
        result += abs(i - y)
    for i in arr[4]:
        result += i + (w-y)
    for i in arr[3]:
        result += i + y
    for i in arr[2]:
        if i >= w-y:
            result += (w-y) + h + (w-i)
        else:
            result += y + h + i
            
elif x == 4:
    for i in arr[4]:
        result += abs(i - y)
    for i in arr[2]:
        result += (w-i) + (h-y)
    for i in arr[1]:
        result += y + (w-i)
    for i in arr[3]:
        if i >= h-y:
            result += (h-y) + w + (h-i)
        else:
            result += y + w + i

print(result)