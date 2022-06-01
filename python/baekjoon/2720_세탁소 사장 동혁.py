import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    a = n // 25
    n %= 25
    b = n // 10
    n %= 10
    c = n // 5
    n %= 5
    d = n
    
    print(a, b, c, d)