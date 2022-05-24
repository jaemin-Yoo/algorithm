for idx in range(1, 11):
    n, pw = input().split()
    arr = list(pw)
    
    i = 0
    while i < len(arr)-1:
        if arr[i] == arr[i+1]:
            arr.pop(i)
            arr.pop(i)
            i -= 1
        else:
            i += 1
    print("#{} {}".format(idx, "".join(arr)))