code = ["0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"]

t = int(input())
for idx in range(1, t+1):
    n, m = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(input())
    
    result = []
    
    for i in range(n):
        j = m-1
        while j > 0:
            if graph[i][j] == "1":
                result.insert(0, code.index(graph[i][j-6:j+1]))
                j -= 7
            else:
                j -= 1
        if result != []:
            break
    
    if result != []:
        odd = 0
        even = 0
        for i in range(1, len(result)):
            if i % 2 == 1:
                odd += result[i-1]
            else:
                even += result[i-1]
                
        v = odd * 3 + even + result[-1]
        if v % 10 == 0:
            print("#{} {}".format(idx, sum(result)))
        else:
            print("#{} 0".format(idx))
    else:
        print("#{} 0".format(idx))