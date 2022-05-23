t = int(input())
for idx in range(1, t+1):
    p = input().rstrip()
    q = input().rstrip()
    if p + "a" != q:
        print("#{} Y".format(idx))
    else:
        print("#{} N".format(idx))