import sys
input = sys.stdin.readline

w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

if ((p + t) // w) % 2 == 1:
    p = w - (p+t)%w
else:
    p = (p+t)%w
    
if ((q + t) // h) % 2 == 1:
    q = h - (q+t)%h
else:
    q = (q+t)%h

print(p, q)