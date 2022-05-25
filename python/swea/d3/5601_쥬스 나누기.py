t = int(input())
for idx in range(1, t+1):
    n = int(input())
    print("#{}".format(idx), end="")
    for _ in range(n):
        print(" ", end="")
        print("1/" + str(n), end="")
    print()