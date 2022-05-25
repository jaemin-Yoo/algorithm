def NQueen(row):
    global cnt
    for j in range(n):
        if j not in c and j+row not in l and j-row not in r:
            if row == n-1:
                cnt += 1
                return
    
            l.append(j+row)
            r.append(j-row)
            c.append(j)
            NQueen(row+1)
            l.pop()
            r.pop()
            c.pop()
        
l = []
r = []
c = []
t = int(input())
for idx in range(1, t+1):
    n = int(input())
    
    cnt = 0
    NQueen(0)
    print("#{} {}".format(idx, cnt))