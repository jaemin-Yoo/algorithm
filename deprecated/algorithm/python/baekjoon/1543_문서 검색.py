import sys
input = sys.stdin.readline

s = input().rstrip()
w = input().rstrip()

idx = 0
cnt = 0
while True:
    
    if w in s[idx:]:
        idx = s.index(w, idx) + len(w)
    else:
        break
    
    cnt += 1

print(cnt)