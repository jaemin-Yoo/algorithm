import sys
input = sys.stdin.readline

n = int(input())
d = {}
for _ in range(n):
    s = input().rstrip()
    if s not in d:
        d[s] = 1
    else:
        d[s] += 1

max_cnt = 0
d = dict(sorted(d.items()))
for k, v in d.items():
    if max_cnt < v:
        max_cnt = v
        result = k

print(result)