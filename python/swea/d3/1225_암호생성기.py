from collections import deque

for i in range(1, 11):
    idx = int(input())
    arr = list(map(int, input().split()))
    q = deque()
    for i in arr:
        q.append(i)
    
    while True:
        for i in range(1, 6):
            v = q.popleft()
            
            if v-i <= 0:
                q.append(0)
                break
            else:
                q.append(v-i)
            
        if q[-1] == 0:
            break
    
    print("#{} {} {} {} {} {} {} {} {}".format(idx, *q))