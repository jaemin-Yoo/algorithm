t = int(input())
for idx in range(1, t+1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    max_val = 0
    if len(a) < len(b):
    	for i in range(m-n+1):
            v = 0
            for j in range(n):
                v += a[j] * b[i+j]
            max_val = max(max_val, v)
    else:
        for i in range(n-m+1):
            v = 0
            for j in range(m):
                v += b[j] * a[i+j]
            max_val = max(max_val, v)
        
        
    print("#{} {}".format(idx, max_val))