import sys
input = sys.stdin.readline

exp = list(input())
stack = []
result = ""
for s in exp:
    if s.isalpha():
        result += s
    elif s == "(":
        stack.append(s)
    elif s == "*" or s == "/":
        while stack and (stack[-1] == "*" or stack[-1] == "/"):
            result += stack.pop()
        stack.append(s)
    elif s == "+" or s == "-":
        while stack and stack[-1] != "(":
            result += stack.pop()
        stack.append(s)
    elif s == ")":
        while stack and stack[-1] != "(":
            result += stack.pop()
        stack.pop()

while stack:
    result += stack.pop()
print(result)