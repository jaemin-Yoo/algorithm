import sys
input = sys.stdin.readline

m = int(input())

s = []
for _ in range(m):
    a = input().strip().split()
    c = a[0]
    
    if c == "add":
        if a[1] not in s:
            s.append(a[1])
    elif c == "remove":
        if a[1] in s:
            s.remove(a[1])
    elif c == "check":
        if a[1] in s:
            print(1)
        else:
            print(0)
    elif c == "toggle":
        if a[1] in s:
            s.remove(a[1])
        else:
            s.append(a[1])
    elif c == "all":
        s = [str(i) for i in range(1, 21)]
    elif c == "empty":
        s = []