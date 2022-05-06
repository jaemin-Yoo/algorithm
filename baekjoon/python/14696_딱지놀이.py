import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    a = list(map(int, input().split()))
    na = a[0]
    pa = a[1:]

    b = list(map(int, input().split()))
    nb = b[0]
    pb = b[1:]

    result = 'D'
    for i in range(4, 0, -1):
        if pa.count(i) > pb.count(i):
            result = 'A'
            break
        elif pa.count(i) < pb.count(i):
            result = 'B'
            break
    print(result)