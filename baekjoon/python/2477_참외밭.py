import sys
input = sys.stdin.readline

n = int(input())

d_list = []
l_list = []
for _ in range(6):
    d, l = map(int, input().split())
    d_list.append(d)
    l_list.append(l)
    
w_max = 0
for i in range(6):
    if d_list[i] == 1 or d_list[i] == 2:
        if l_list[i] > w_max:
            w_max = l_list[i]
            w_idx = i
h_max = max(l_list[(w_idx-1) % 6], l_list[(w_idx+1) % 6])

if l_list[((w_idx-1) % 6)] > l_list[(w_idx+1) % 6]:
    b_w = l_list[(w_idx + 2) % 6]
else:
    b_w = l_list[(w_idx - 2) % 6]

b_h = abs(l_list[(w_idx-1) % 6] - l_list[(w_idx+1) % 6])

rec = w_max * h_max
b_rec = b_w * b_h

print((rec - b_rec) * n)