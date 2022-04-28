t = int(input())
for idx in range(1, t+1):
    h1, m1, h2, m2 = map(int, input().split())
    h3 = (m1 + m2) // 60
    m = (m1 + m2) % 60
    h = (h1 + h2 + h3) % 12
    if h == 0:
        h = 12
        
    print("#{} {} {}".format(idx, h, m))