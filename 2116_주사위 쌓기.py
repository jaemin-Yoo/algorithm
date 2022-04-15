import sys
input = sys.stdin.readline

def getMax(i, row, result):
    prev = 0
    max_val = 0
    if i == 0 or i == 5:
        if i == 0:
            prev = row[5]
        else:
            prev = row[0]
        row.pop(5)
        row.pop(0)
        max_val = max(row)
    elif i == 1 or i == 3:
        if i == 1:
            prev = row[3]
        else:
            prev = row[1]
        row.pop(3)
        row.pop(1)
        max_val = max(row)
    elif i == 2 or i == 4:
        if i == 2:
            prev = row[4]
        else:
            prev = row[2]
        row.pop(4)
        row.pop(2)
        max_val = max(row)
    
    return prev, result + max_val

n = int(input())

dice = []
for _ in range(n):
    dice.append(list(map(int, input().split())))
    
result = 0
for i in range(1, 7):
    max_val = 0
    prev = i
    for j in range(n):
        idx = dice[j].index(prev)
        prev, max_val = getMax(idx, dice[j][:], max_val)
    result = max(result, max_val)
print(result)