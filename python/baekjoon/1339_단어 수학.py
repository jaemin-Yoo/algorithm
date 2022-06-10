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

number = ['', '', '', '', '', '', '', '', '', '']

cnt = 9
result = ['' for _ in range(n)]
for j in range(max_len):
    for i in range(n):
        if arr[i][j] != '':
            if arr[i][j] in number:
                result[i] += str(number.index(arr[i][j]))
            else:
                number[cnt] = arr[i][j]
                result[i] += str(cnt)
                cnt -= 1

ans = 0
for v in result:
    ans += int(v)

print(ans)