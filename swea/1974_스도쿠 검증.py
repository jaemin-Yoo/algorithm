def check():
    for i  in range(9):
        if len(set(graph[i])) != 9:
            return 0
        
        if len(set([j[i] for j in graph])) != 9:
            return 0
        
        temp = []
        for x in range((i*3)%9, (i*3)%9+3):
            for y in range((i//3)*3, (i//3)*3+3):
                temp.append(graph[x][y])
        if len(set(temp)) != 9:
            return 0
    return 1

t = int(input())
for idx in range(1, t+1):
    graph = []
    for _ in range(9):
        graph.append(list(map(int, input().split())))
    
    print("#{} {}".format(idx, check()))