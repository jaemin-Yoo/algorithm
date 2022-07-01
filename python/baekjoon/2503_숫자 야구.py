import sys
input = sys.stdin.readline

n = int(input())
baseball = []
for _ in range(n):
    baseball.append(list(map(int, input().split())))

result = 0
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i != j and i != k and j != k:
                res = str(i)+str(j)+str(k)
                
                state = True
                for arr in baseball:
                    num = str(arr[0])
                    s = 0
                    b = 0
                    for idx in range(3):
                        if res[idx] == num[idx]:
                            s +=1
                        elif num[idx] in res:
                            b += 1
                    
                    if arr[1] != s or arr[2] != b:
                        state = False
                        break
                
                if state:
                    result += 1
print(result)