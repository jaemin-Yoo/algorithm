import sys
input = sys.stdin.readline

n = int(input())
result = []
for i in range(1, n+1):
    temp = []
    v = n
    while v >= 0:
        temp.append(v)
        a = v - i
        v = i
        i = a
    
    if len(temp) > len(result):
        result = temp
print(len(result))
print(*result)