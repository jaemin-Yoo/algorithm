import sys
input = sys.stdin.readline

n = int(input())
arr = set()
result = 0
for _ in range(n):
    s = input().rstrip()
    if s == "ENTER":
        arr = set()
    elif s not in arr:
        arr.add(s)
        result += 1
print(result)