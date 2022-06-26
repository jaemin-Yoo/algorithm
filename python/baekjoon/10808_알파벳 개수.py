import sys
input = sys.stdin.readline

s = input().rstrip()
for i in range(26):
    print(s.count(chr(i+97)), end=" ")