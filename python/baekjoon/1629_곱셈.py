import sys

def dnc(a, b):
    if b == 1:
        return a % c
    
    v = dnc(a, b // 2)
    
    if b % 2 == 0:
        return v * v % c
    else:
        return v * v * a % c
        

input = sys.stdin.readline

a, b, c = map(int, input().split())
print(dnc(a, b))