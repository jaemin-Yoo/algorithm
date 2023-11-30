import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
a = []
b = [i for i in range(10)]
if m > 0 :
    a = list(map(int, input().strip().split()))
for i in a:
    b.remove(i)

mv = '100'
mn = abs(n - 100)
state = 0
def solve(l):
    global mn, mv, n, state
    
    if len(s) == l:
        if state == 1:
            return
        
        t = ""
        for i in s:
            t += str(i)
        temp = abs(n - int(t))+len(t)
        if mn > temp:
            mn = temp
            mv = t
        
        if int(n) < int(t) and mn < temp:
            state = 1
        return
    
    for i in range(len(b)):
        s.append(b[i])
        solve(l)
        s.pop()

result = []
for i in range(1, len(str(n))+2):
    s= []
    solve(i)
print(mn)