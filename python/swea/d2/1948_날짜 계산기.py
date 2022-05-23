t = int(input())
for idx in range(1, t+1):
    m1, d1, m2, d2 = map(int, input().split())
    m_d = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    days = 0
    if m1 != m2:
        for i in range(m1+1, m2):
            days += m_d[i]
        days += m_d[m1] - d1 + d2 + 1
    else:
        days = d2 - d1 + 1
    
    print("#{} {}".format(idx, days))