for idx in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    c = int(input())
    cmd = list(input().split())
    
    i = 0
    for _ in range(c):
        if cmd[i] == "I":
            for j in range(int(cmd[i+2])):
                arr.insert(int(cmd[i+1])+j, int(cmd[i+3+j]))
            i += int(cmd[i+2]) + 3
        elif cmd[i] == "D":
            for _ in range(int(cmd[i+2])):
                arr.pop(int(cmd[i+1]))
            i += 3
        elif cmd[i] == "A":
            for j in range(int(cmd[i+1])):
                arr.append(int(cmd[i+2+j]))
            i += int(cmd[i+1]) + 2
        print(arr)
    
    print("#{}".format(idx), end=" ")
    m = min(len(arr), 10)
    for i in range(m):
        print(arr[i], end=" ")