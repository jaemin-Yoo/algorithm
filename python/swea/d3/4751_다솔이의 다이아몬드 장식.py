t = int(input())
for idx in range(1, t+1):
    s = input()
    
    row1 = ""
    row2 = ""
    row3 = ""
    row4 = ""
    row5 = ""
    for i in s:
        row1 += "..#.."
        row2 += ".#.#."
        row3 += "#." + i + "."
        row4 += ".#.#."
        row5 += "..#.."
    
    print(row1)
    print(row2)
    print(row3 + "#")
    print(row4)
    print(row5)