t = int(input())

score = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
for idx in range(1, t+1):
    n, k = map(int, input().split())
    
    d = n // 10
    
    arr = []
    for i in range(1, n+1):
        a, b, c = map(int, input().split())
        arr.append((a * 0.35 + b * 0.45 + c * 0.2, i))
        
    arr = sorted(arr, key=lambda x:-x[0])
    for i in range(n):
        if arr[i][1] == k:
            print("#{} {}".format(idx, score[i//d]))