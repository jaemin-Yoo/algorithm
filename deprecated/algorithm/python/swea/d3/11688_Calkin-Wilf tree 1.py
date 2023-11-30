t = int(input())
for idx in range(1, t+1):
    s = input()
    a, b = 1, 1
    for i in s:
        if i == "L":
            a, b = a, a+b
        else:
            a, b = a+b, b
    print("#{} {} {}".format(idx, a, b))