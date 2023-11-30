import sys
input = sys.stdin.readline

m = int(input())

s = set()
for _ in range(m):
    a = input().strip().split()
    c = a[0]
    
    if len(a) == 1:
        if c == "all":
            s = set([i for i in range(1, 21)])
        elif c == "empty":
            s = set()
        continue
    
    v = int(a[1])
    if c == "add":
        s.add(v)
    elif c == "remove":
        s.discard(v)
    elif c == "check":
        if v in s:
            print(1)
        else:
            print(0)
    elif c == "toggle":
        if v in s:
            s.discard(v)
        else:
            s.add(v)