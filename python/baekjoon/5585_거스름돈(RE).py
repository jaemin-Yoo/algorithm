import sys
input = sys.stdin.readline

n = int(input())
change = [500, 100, 50, 10, 5, 1]
price = 1000 - n
result = 0
for i in change:
    result += price // i
    price %= i
print(result)