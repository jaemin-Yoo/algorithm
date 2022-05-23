t = int(input())
for idx in range(1, t+1):
    a, b = map(int, input().split())
    print("#{} {}".format(idx, (a + b) % 24))