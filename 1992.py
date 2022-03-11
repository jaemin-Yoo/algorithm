import sys

def check(board):
    for i in board:
        for j in i:
            if j != board[0][0]:
                return False
    print(board[0][0], end="")    
    return True

def divide(arr):
    a = []
    b = []
    c = []
    d = []
    n = len(arr[0])
    for i in range(n):
        if i < int(n/2):
            a.append(arr[i][:int(n/2)])
            b.append(arr[i][int(n/2):n])
        else:
            c.append(arr[i][:int(n/2)])
            d.append(arr[i][int(n/2):n])

    if check(a)==False:
        print("(", end="")
        divide(a)
        print(")", end="")
    if check(b)==False:
        print("(", end="")
        divide(b)
        print(")", end="")
    if check(c)==False:
        print("(", end="")
        divide(c)
        print(")", end="")
    if check(d)==False:
        print("(", end="")
        divide(d)
        print(")", end="")
    
input = sys.stdin.readline

n = int(input())
board = []
for _ in range(n):
    board.append(input().strip())

if check(board)==False:
    print("(", end="")
    divide(board)
    print(")", end="")