import sys
input = sys.stdin.readline

s = input().rstrip()
n = len(s)
result = ["" for _ in range(n)]

s = "".join(sorted(s))
d = {}
for i in set(s):
    d[i] = 0
    
for i in s:
    d[i] += 1


cnt = 0
for k, v in d.items():
    if v % 2 == 1:
        cnt += 1
        result[len(s)//2] = k
        d[k] -= 1

s = sorted(set(s))
idx = 0
for i in s:
    for j in range(d[i]//2):
        result[idx]= i
        result[n-idx-1] = i
        idx += 1
        
if cnt > 1:
    print("I'm Sorry Hansoo")
else:
    print("".join(result))