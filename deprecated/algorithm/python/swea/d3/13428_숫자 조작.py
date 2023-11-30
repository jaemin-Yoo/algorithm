t = int(input())
for idx in range(1, t+1):
    n_list = list(input())
    
    result = [int(''.join(n_list))]
    for i in range(len(n_list)):
        for j in range(i+1, len(n_list)):
            temp = n_list[i]
            n_list[i] = n_list[j]
            n_list[j] = temp
            if n_list[0] != "0":
                result.append(int(''.join(n_list)))
            temp = n_list[i]
            n_list[i] = n_list[j]
            n_list[j] = temp
    print("#{} {} {}".format(idx, min(result), max(result)))