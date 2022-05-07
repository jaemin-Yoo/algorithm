n = int(input())
for i in range(1, n+1):
    result = ""
    for s in str(i):
        if int(s)%3 == 0 and s != "0":
            result += "-"
            
    if result != "":
        print(result, end=" ")
    else:
        print(i, end=" ")