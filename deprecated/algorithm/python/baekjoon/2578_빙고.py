import sys
input = sys.stdin.readline

graph = []
dict = {}
for i in range(5):
    row = list(map(int, input().split()))
    graph.append(row)
    for j, v in enumerate(row):
        dict[str(v)] = (i, j)

count = 0
num = 0
v_list = []
for _ in range(5):
    v_list.extend(list(map(int, input().split())))

for v in v_list:
    num += 1
    i, j = dict[str(v)]
    graph[i][j] = 0

    if len(set(graph[i])) == 1:
        count += 1

    if len(set([tmp[j] for tmp in graph])) == 1:
        count += 1

    if i == j:
        count += 1
        for a in range(5):
            if graph[a][a] != 0:
                count -= 1
                break
    
    if i + j == 4:
        count += 1
        for a in range(5):
            if graph[a][4-a] != 0:
                count -= 1
                break
    
    if count >= 3:
        print(num)
        break