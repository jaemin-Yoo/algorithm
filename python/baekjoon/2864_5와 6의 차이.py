import sys
input = sys.stdin.readline

n, m = map(int, input().split())

sn = str(n)
min_n = ""
max_n = ""
for i in sn:
    if i == "5" or i == "6":
        min_n += "5"
        max_n += "6"
    else:
        min_n += i
        max_n += i

sm = str(m)
min_m = ""
max_m = ""
for i in sm:
    if i == "5" or i == "6":
        min_m += "5"
        max_m += "6"
    else:
        min_m += i
        max_m += i

print(int(min_n) + int(min_m), int(max_n) + int(max_m))