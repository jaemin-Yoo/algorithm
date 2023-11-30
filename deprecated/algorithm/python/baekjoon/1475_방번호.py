import sys
import math
input = sys.stdin.readline

s = input()
max_cnt = 0
for i in range(len(s)):
    if s[i] == "9" or s[i] == "6":
        cnt = math.ceil((s.count("6") + s.count("9")) / 2)
    else:
        cnt = s.count(s[i])
    max_cnt = max(cnt, max_cnt)
print(max_cnt)