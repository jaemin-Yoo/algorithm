for _ in range(4):
    x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())
    
    xl = max(x1, x2)
    xr = min(p1, p2)
    yt = min(q1, q2)
    yb = max(y1, y2)
    
    if xr - xl >= 0 and yt - yb >= 0:
        if xr - xl == 0 or yt - yb == 0:
            if xr - xl == 0 and yt - yb == 0:
                print("c")
            else:
                print("b")
        else:
            print("a")
    else:
        print("d")