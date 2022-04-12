import sys
input = sys.stdin.readline

n = int(input())
switch = [0] + list(map(int, input().split()))
m = int(input())
for _ in range(m):
    s, v = map(int, input().split())
    t = v
    if s == 1:
        while v < len(switch):
            switch[v] = switch[v] ^ 1
            v += t
    else:
        a = v - 1
        b = v + 1
        switch[v] = switch[v] ^ 1
        while 1<=a and b<len(switch) and switch[a] == switch[b]:
            switch[a] = switch[a] ^ 1
            switch[b] = switch[b] ^ 1
            a -= 1
            b += 1

switch.remove(0)
for i in range(len(switch)):
    print(switch[i], end=" ")
    if i % 20 == 19:
        print()