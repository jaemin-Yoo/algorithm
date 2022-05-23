import sys
input = sys.stdin.readline

t = int(input())
result = []

result.append(t // 300)
t %= 300

result.append(t // 60)
t %= 60

result.append(t // 10)
t %= 10
    
if t == 0:
    print(*result)
else:
    print(-1)