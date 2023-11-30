import sys
import math
input = sys.stdin.readline

n = int(input())
s = input().rstrip()
c_cnt = 0
s_cnt = 0
for i in s:
    if i == "C":
        c_cnt += 1
    else:
        s_cnt += 1
        
print(math.ceil(c_cnt / (s_cnt + 1)))