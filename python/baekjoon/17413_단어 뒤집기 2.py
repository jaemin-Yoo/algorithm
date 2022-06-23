import sys
input = sys.stdin.readline

s = input().rstrip()
result = ""
state = ">"
temp = ""
for c in s:
    if c == "<":
        result += temp
        result += c
        state = c
        temp = ""
    elif c == ">":
        result += c
        state = c
    elif state == "<":
        result += c
    elif c == " ":
        result += temp
        result += c
        temp = ""
    else:
        temp = c + temp
result += temp
print(result)