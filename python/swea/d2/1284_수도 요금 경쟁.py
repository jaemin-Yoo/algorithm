t = int(input())
for idx in range(1, t+1):
    p, q, r, s, w = map(int, input().split())
    
    a = w * p
    if w <= r:
        b = q
    else:
        b = q + s * (w - r)
        
    print("#{} {}".format(idx, min(a, b)))