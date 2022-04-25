import sys
input = sys.stdin.readline

def getDistance(idx, pos):
    if idx == 1:
        return h + pos
    elif idx == 2:
        return h + w + h + w - pos
    elif idx == 3:
        return h - pos
    elif idx == 4:
        return h + w + pos

w, h = map(int, input().split())
n = int(input())
arr = []
for _ in range(n):
    d, dst = map(int, input().split())
    arr.append(getDistance(d, dst))
p, pd = map(int, input().split())
mDist = getDistance(p, pd)
recDist = 2*w + 2*h

result = 0
for i in arr:
    v = abs(i - mDist)
    result += min(v, recDist - v)
print(result)