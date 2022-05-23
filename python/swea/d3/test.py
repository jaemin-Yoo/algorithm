import copy
from collections import deque

def bfs(start):
    q = deque()
    q.append(start)
    start[3][start[0]][start[1]] -= 1
    result = start[2]
    while q:
        x, y, result, graph = q.popleft()
        if graph[y][0] != 0:
            graph[y][0] -= 1
            q.append((y, 0, result+"0", copy.deepcopy(graph)))
        if graph[y][1] != 0:
            graph[y][1] -= 1
            q.append((y, 1, result+"1", copy.deepcopy(graph)))

        cnt = 0
        for i in range(2):
            for j in range(2):
                if graph[i][j] == 0:
                    cnt += 1
        if cnt == 4:
            return result

    return "impossible"


t = int(input())
for idx in range(1, t+1):
    a, b, c, d = map(int, input().split())

    binary = [[0, 0], [0, 0]]
    binary[0][0] = a
    binary[0][1] = b
    binary[1][0] = c
    binary[1][1] = d

    ans = ""
    for i in range(2):
        for j in range(2):
            if binary[i][j] != 0:
                start = (i, j, str(i)+str(j), copy.deepcopy(binary))
                ans = bfs(start)
                if ans != "impossible":
                    print("#{} {}".format(idx, ans))
                    break
        if ans != "impossible":
            break

    if ans == "impossible":
        print("#{} {}".format(idx, ans))