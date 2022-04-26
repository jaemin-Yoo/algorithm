import sys
input = sys.stdin.readline

n = int(input())

rec = [0 for _ in range(1001)]
for _ in range(n):
    l, h = map(int, input().split())
    rec[l] = h
max_idx = rec.index(max(rec))

max_val = 0
for i in range(max_idx):
    max_val = max(max_val, rec[i])
    rec[i] = max_val

max_val = 0
for i in range(1000, max_idx, -1):
    max_val = max(max_val, rec[i])
    rec[i] = max_val

print(sum(rec))