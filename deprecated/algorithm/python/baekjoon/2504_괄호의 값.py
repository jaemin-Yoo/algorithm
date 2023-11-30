import sys
input = sys.stdin.readline

arr = list(input().rstrip())
stack = []
result = 0
num = 1
for i in range(len(arr)):
    if arr[i] == '(' or arr[i] == '[':
        if arr[i] == '(':
            num *= 2
        else:
            num *= 3
        stack.append(arr[i])
    elif arr[i] == ')':
        if not stack:
            result = 0
            break
        
        v = stack.pop()
        if arr[i-1] == '(':
            result += num
        elif v != '(':
            result = 0
            break
        num //= 2
        
    elif arr[i] == ']':
        if not stack:
            result = 0
            break
        
        v = stack.pop()
        if arr[i-1] == '[':
            result += num
        elif v != '[':
            result = 0
            break
        num //= 3
        
if not stack:
    print(result)
else:
    print(0)