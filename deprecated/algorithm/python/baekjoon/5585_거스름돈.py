import sys
input = sys.stdin.readline

n = int(input())
price = 1000 - n
result = 0
while price != 0:
    if price >= 500:
        result += price // 500
        price %= 500
    elif price >= 100:
        result += price // 100
        price %= 100
    elif price >= 50:
        result += price // 50
        price %= 50
    elif price >= 10:
        result += price // 10
        price %= 10
    elif price >= 5:
        result += price // 5
        price %= 5
    else:
        result += price // 1
        price %= 1
print(result)