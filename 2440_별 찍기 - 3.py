import sys
input = sys.stdin.readline

n = int(input())
for i in range(n):
    for j in range(i, n):
        print("*", end="")
    print()