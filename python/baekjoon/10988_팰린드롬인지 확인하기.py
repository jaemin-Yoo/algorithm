import sys
input = sys.stdin.readline

s = input().rstrip()
result = 1
for i in range(len(s)//2):
    if s[i] != s[len(s)-i-1]:
        result = 0
        break
print(result)