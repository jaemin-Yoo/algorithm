import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
broken = list(map(int, input().strip().split()))

min_count = abs(n-100)
for i in range(1000001):
    s = str(i)
    
    for j in range(len(s)):
        if int(s[j]) in broken:
            break
        elif j == len(s) - 1:
            min_count = min(min_count, abs(n - int(s))+len(s))
print(min_count)