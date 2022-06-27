import sys
input = sys.stdin.readline

s = input().rstrip()
for c in s:
    if 65<=ord(c)<=90:
        print(c, end="")