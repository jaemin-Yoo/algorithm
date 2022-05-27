import sys
input = sys.stdin.readline

s = input().rstrip()
s0 = s.split("0")
s1 = s.split("1")
cnt0 = 0
for i in s0:
    if i != '':
        cnt0 += 1
        
cnt1 = 0
for i in s1:
    if i != '':
        cnt1 += 1

print(min(cnt0, cnt1))