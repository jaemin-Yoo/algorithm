import sys
input = sys.stdin.readline

n = int(input())
a, b = map(int, input().split())
print(min(a // 2 + b, n))