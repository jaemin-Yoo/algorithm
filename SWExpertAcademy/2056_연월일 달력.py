t = int(input())
for i in range(1, t+1):
    s = input()
    m = int(s[4:6])
    d = int(s[6:])
    if m == 1 or m == 3 or m == 5 or m == 7 or m == 8 or m == 10 or m == 12 and 1 <= d <= 31:
        print("#{} {}/{}/{}".format(i, s[:4], s[4:6], s[6:]))
    elif m == 4 or m == 6 or m == 9 or m == 11 and 1 <= d <= 30:
        print("#{} {}/{}/{}".format(i, s[:4], s[4:6], s[6:]))
    elif m == 2 and 1 <= d <= 28:
        print("#{} {}/{}/{}".format(i, s[:4], s[4:6], s[6:]))
    else:
        print("#{} -1".format(i))