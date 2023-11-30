import sys
input = sys.stdin.readline

idx = 1
while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:
        break
    result = (v // p) * l +  min(v - (v // p) * p, l)
    print("Case {}: {}".format(idx, result))
    idx += 1