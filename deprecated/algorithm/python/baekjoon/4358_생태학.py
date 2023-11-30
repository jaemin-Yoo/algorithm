import sys
input = sys.stdin.readline

d = {}
sm = 0
while True:
    s = input().rstrip()
    if not s:
        break
    
    if s not in d:
        d[s] = 1
    else:
        d[s] += 1
        
    sm += 1
d = sorted(d.items())
for i, cnt in d:
    print("{} {:.4f}".format(i, cnt/sm*100))