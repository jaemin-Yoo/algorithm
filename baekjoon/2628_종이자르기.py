import sys
input = sys.stdin.readline

w, h = map(int, input().split())
n = int(input())

x_list = [h]
y_list = [w]
for _ in range(n):
    a, b = map(int, input().split())
    if a == 0:
        x_list.append(b)
    else:
        y_list.append(b)

x_list.sort()
y_list.sort()

pi = 0
max_val = 0
for i in x_list:
    pj = 0
    for j in y_list:
        max_val = max(max_val, (i-pi) * (j-pj))
        pj = j
    pi = i
print(max_val)