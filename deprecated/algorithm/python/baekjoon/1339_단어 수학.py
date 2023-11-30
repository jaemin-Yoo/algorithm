import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(list(input().rstrip()))

max_len = max(len(row) for row in arr)
for row in arr:
    diff = max_len - len(row)
    for _ in range(diff):
        row.insert(0, '')

result = ['' for _ in range(n)]
d = {}
for j in range(max_len):
    for i in range(n):
        if arr[i][j] != '':
            if arr[i][j] not in d:
                d[arr[i][j]] = 10 ** (max_len - j)
            else:    
                d[arr[i][j]] += 10 ** (max_len - j)
                
d = dict(sorted(d.items(), key=lambda x:x[1], reverse=True))

number = ['', '', '', '', '', '', '', '', '', '']
cnt = 9
for k in d.keys():
    number[cnt] = k
    cnt -= 1

for j in range(max_len):
    for i in range(n):
        if arr[i][j] != '':
            result[i] += str(number.index(arr[i][j]))

ans = 0
for v in result:
    ans += int(v)

print(ans)