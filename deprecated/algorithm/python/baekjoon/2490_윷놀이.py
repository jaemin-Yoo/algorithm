import sys
input = sys.stdin.readline

yut = ['E', 'A', 'B', 'C', 'D']
for _ in range(3):
    arr = list(map(int, input().split()))
    print(yut[arr.count(0)])